package be.technifutur.game.metier.mapper;

import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.entities.Game;
import be.technifutur.game.models.forms.GameInsertForm;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameMapper {

    public GameDTO entityToDTO(Game entity) {
        if (entity == null) {
            return null;
        }

        Developer developerEntity = entity.getDeveloper();
        GameDTO.DeveloperDTO developer = developerEntity == null ? null : new GameDTO.DeveloperDTO(developerEntity.getReference(), developerEntity.getName());

        Editor editorEntity = entity.getEditor();
        GameDTO.EditorDTO editor = editorEntity == null ? null : new GameDTO.EditorDTO(editorEntity.getReference(), editorEntity.getName());

        return GameDTO.builder()
                .id(entity.getId())
                .reference(entity.getReference())
                .title(entity.getTitle())
                .releaseDate(entity.getReleaseDate())
                .genre(entity.getGenre())
                .developer(developer)
                .editor(editor)
                .build();
    }


    public Game formToEntity(GameInsertForm form){
        if (form == null){
            return null;
        }

        return Game.builder()
                .title(form.getTitle())
                .reference(UUID.randomUUID())
                .releaseDate(form.getReleaseDate())
                .genre(form.getGenre())
                .build();
    }
}
