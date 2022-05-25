package be.technifutur.game.metier.service.editor;

import be.technifutur.game.exceptions.ElementNotFoundException;
import be.technifutur.game.metier.mapper.EditorMapper;
import be.technifutur.game.models.dto.EditorDTO;
import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.entities.Game;
import be.technifutur.game.models.forms.EditorForm;
import be.technifutur.game.repository.EditorRepository;
import be.technifutur.game.repository.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EditorServiceImpl implements EditorService {

    private final EditorRepository repository;
    private final EditorMapper mapper;
    private final GameRepository gameRepository;

    public EditorServiceImpl(EditorRepository repository, EditorMapper mapper, GameRepository gameRepository) {
        this.repository = repository;
        this.mapper = mapper;
        this.gameRepository = gameRepository;
    }

    @Override
    public List<EditorDTO> getDevelopers() {
        return repository.findAll()
                .stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    @Override
    public EditorDTO getEditorByReference(UUID reference) {
        EditorDTO editorDTO = repository.findByReference(reference)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(reference, Editor.class));
        return editorDTO;
    }

    @Override
    public EditorDTO getEditorByName(String name) {
        EditorDTO editorDTO = repository.findByName(name)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new ElementNotFoundException(name, Editor.class));
        return editorDTO;
    }

    @Override
    public EditorDTO insertEditor(EditorForm editorForm) {
        Editor entity = mapper.formToEntity(editorForm);
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public EditorDTO updateEditor(UUID reference, EditorForm editorForm) {
        Editor entity = repository.findByReference(reference)
                .orElseThrow(() -> new ElementNotFoundException(reference, Editor.class));
        entity.setName(editorForm.getName());
        entity = repository.save(entity);
        return mapper.entityToDTO(entity);
    }

    @Override
    public EditorDTO deleteEditor(UUID reference) {
        Editor entity = repository.findByReference(reference)
                .orElseThrow(() -> new ElementNotFoundException(reference, Editor.class));
        for (Game game : entity.getGames()){
            game.setEditor(null);
            gameRepository.save(game);
        }
        EditorDTO dto = getEditorByReference(reference);
        repository.deleteByReference(reference);
        return dto;
    }
}
