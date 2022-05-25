package be.technifutur.game.metier.mapper;

import be.technifutur.game.models.dto.DeveloperDTO;
import be.technifutur.game.models.dto.EditorDTO;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.forms.EditorForm;
import org.springframework.stereotype.Service;

@Service
public class EditorMapper {

    public EditorDTO entityToDTO(Editor entity) {
        if (entity == null) {
            return null;
        }

        return EditorDTO.builder()
                .id(entity.getId())
                .reference(entity.getReference())
                .name(entity.getName())
                .games(entity.getGames() == null ? null : entity.getGames().stream().map(EditorDTO.GameDTO::of).toList())
                .build();
    }

    public Editor formToEntity(EditorForm form) {
        if (form == null) {
            return null;
        }

        return Editor.builder()
                .name(form.getName())
                .build();
    }
}
