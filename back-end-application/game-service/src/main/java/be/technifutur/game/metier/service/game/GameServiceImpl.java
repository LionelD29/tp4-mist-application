package be.technifutur.game.metier.service.game;

import be.technifutur.game.exceptions.ElementNotFoundException;
//import be.technifutur.game.feign.MarketClient;
import be.technifutur.game.feign.MarketClient;
import be.technifutur.game.metier.mapper.GameMapper;
import be.technifutur.game.metier.service.developer.DeveloperService;
import be.technifutur.game.metier.service.editor.EditorService;
import be.technifutur.game.models.dto.DetailedGameDTO;
import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.dto.MarketDTO;
import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.entities.Game;
import be.technifutur.game.models.forms.DeveloperForm;
import be.technifutur.game.models.forms.EditorForm;
import be.technifutur.game.models.forms.GameInsertForm;
import be.technifutur.game.models.forms.GameUpdateForm;
import be.technifutur.game.repository.DeveloperRepository;
import be.technifutur.game.repository.EditorRepository;
import be.technifutur.game.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class GameServiceImpl implements GameService{

    private final GameRepository repository;
    private final GameMapper mapper;
    private final DeveloperRepository developerRepository;
    private final EditorRepository editorRepository;
    private final DeveloperService developerService;
    private final EditorService editorService;
    private final MarketClient marketClient;

    public GameServiceImpl(GameRepository repository, GameMapper mapper, DeveloperRepository developerRepository, EditorRepository editorRepository, DeveloperService developerService, EditorService editorService, MarketClient marketClient) {
        this.repository = repository;
        this.mapper = mapper;
        this.developerRepository = developerRepository;
        this.editorRepository = editorRepository;
        this.developerService = developerService;
        this.editorService = editorService;
        this.marketClient = marketClient;
    }

    @Override
    public List<DetailedGameDTO> getGames() {
        List<MarketDTO> marketDTO = marketClient.getAll();
        List<GameDTO> gameDTO = repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
        List<DetailedGameDTO> list = new ArrayList<>();

        for (MarketDTO market: marketDTO){
            GameDTO game = gameDTO.stream()
                    .filter(
                            g -> g.getReference()
                                    .equals(market.getGameRef()))
                    .findFirst()
                    .orElseThrow(() -> new ElementNotFoundException(market.getGameRef(), GameDTO.class));
            DetailedGameDTO detailedGameDTO = mapper.simpleToDetailedDTO(market, game);
            list.add(detailedGameDTO);
        }
        return list;
    }

    @Override
    public DetailedGameDTO getGameByReference(UUID reference) {
        GameDTO gameDTO = repository.findByReference(reference)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(reference, Game.class));
        MarketDTO marketDTO = marketClient.getOneByRef(reference);
        DetailedGameDTO detailedGameDTO = mapper.simpleToDetailedDTO(marketDTO, gameDTO);
        return detailedGameDTO;
    }

    @Override
    public DetailedGameDTO getGameByTitle(String title) {
        GameDTO gameDTO = repository.findByTitle(title)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(title, Game.class));
        MarketDTO marketDTO = (MarketDTO) marketClient.getAll().stream().filter(ti -> ti.equals(title));
        DetailedGameDTO detailedGameDTO = mapper.simpleToDetailedDTO(marketDTO, gameDTO);
        return detailedGameDTO;
    }

    @Override
    public GameDTO insertGame(GameInsertForm gameForm) {
        Game entity = mapper.formToEntity(gameForm);
        Optional<Developer> dev = developerRepository.findByName(gameForm.getDeveloper().getName());
        Developer developer = null;

        if (dev.isPresent()){
            developer = dev.get();

        } else {
            developerService.insertDeveloper(new DeveloperForm(gameForm.getDeveloper().getName()));
            developer = developerRepository.findByName(gameForm.getDeveloper().getName())
                    .orElseThrow(() -> new ElementNotFoundException(gameForm.getDeveloper().getName(), Developer.class));
        }
        entity.setDeveloper(developer);

        Optional<Editor> edit = editorRepository.findByName(gameForm.getEditor().getName());
        Editor editor = null;

        if (edit.isPresent()){
            editor = edit.get();

        } else {
            editorService.insertEditor(new EditorForm(gameForm.getEditor().getName()));
            editor = editorRepository.findByName(gameForm.getEditor().getName())
                    .orElseThrow(() -> new ElementNotFoundException(gameForm.getEditor().getName(), Editor.class));
        }
        entity.setEditor(editor);

        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public GameDTO updateGame(UUID reference, GameUpdateForm gameForm) {
        Game entity = repository.findByReference(reference)
                .orElseThrow(() -> new ElementNotFoundException(reference, Game.class));
        entity.setTitle(gameForm.getTitle());
        entity.setReleaseDate(gameForm.getReleaseDate());
        entity.setGenres(gameForm.getGenres());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public DetailedGameDTO deleteGame(UUID reference) {
        DetailedGameDTO dto = getGameByReference(reference);
        repository.deleteByReference(reference);
        return dto;
    }

    @Override
    public GameDTO updateDeveloperOfGame(UUID gameReference, UUID devReference) {
        Game game = repository.findByReference(gameReference)
                .orElseThrow(() -> new ElementNotFoundException(gameReference, Game.class));
        Developer developer = developerRepository.findByReference(devReference)
                .orElseThrow(() -> new ElementNotFoundException(devReference, Developer.class));
        game.setDeveloper(developer);
        return mapper.entityToDTO(game);
    }

    @Override
    public GameDTO updateEditorOfGame(UUID gameReference, UUID edReference) {
        Game game = repository.findByReference(gameReference)
                .orElseThrow(() -> new ElementNotFoundException(gameReference, Game.class));
        Editor editor = editorRepository.findByReference(edReference)
                .orElseThrow(() -> new ElementNotFoundException(edReference, Developer.class));
        game.setEditor(editor);
        return mapper.entityToDTO(game);
    }
}
