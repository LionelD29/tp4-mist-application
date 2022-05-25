package be.technifutur.game.metier.service.developer;

import be.technifutur.game.exceptions.ElementNotFoundException;
import be.technifutur.game.metier.mapper.DeveloperMapper;
import be.technifutur.game.models.dto.DeveloperDTO;
import be.technifutur.game.models.dto.EditorDTO;
import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.entities.Game;
import be.technifutur.game.models.forms.DeveloperForm;
import be.technifutur.game.repository.DeveloperRepository;
import be.technifutur.game.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService{

    private final DeveloperRepository repository;
    private final DeveloperMapper mapper;
    private final GameRepository gameRepository;

    public DeveloperServiceImpl(DeveloperRepository repository, DeveloperMapper mapper, GameRepository gameRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.gameRepository = gameRepository;
    }

    @Override
    public List<DeveloperDTO> getDevelopers() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public DeveloperDTO getDeveloperByReference(UUID reference) {
        DeveloperDTO developerDTO = repository.findByReference(reference)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(reference, Developer.class));
        return developerDTO;
    }

    @Override
    public DeveloperDTO getDeveloperByName(String name) {
        DeveloperDTO developerDTO = repository.findByName(name)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(name, Developer.class));
        return developerDTO;
    }

    @Override
    public DeveloperDTO insertDeveloper(DeveloperForm developerForm) {
        Developer entity = mapper.formToEntity(developerForm);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public DeveloperDTO updateDeveloper(UUID reference, DeveloperForm developerForm) {
        Developer entity = repository.findByReference(reference)
                .orElseThrow(() -> new ElementNotFoundException(reference, Developer.class));
        entity.setName(developerForm.getName());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public DeveloperDTO deleteDeveloper(UUID reference) {
        Developer entity = repository.findByReference(reference)
                .orElseThrow(() -> new ElementNotFoundException(reference, Developer.class));
        for (Game game : entity.getGames()){
            game.setDeveloper(null);
            gameRepository.save(game);
        }
        DeveloperDTO dto = getDeveloperByReference(reference);
        repository.deleteByReference(reference);
        return dto;
    }
}
