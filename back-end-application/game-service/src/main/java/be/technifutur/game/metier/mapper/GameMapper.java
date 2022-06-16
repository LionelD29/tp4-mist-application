package be.technifutur.game.metier.mapper;

import be.technifutur.game.models.dto.*;
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
                .imageUrl(entity.getImageUrl())
                .releaseDate(entity.getReleaseDate())
                .genres(entity.getGenres())
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
                .imageUrl(form.getImageUrl())
                .releaseDate(form.getReleaseDate())
                .genres(form.getGenres())
                .build();
    }

    public DetailedGameDTO simpleToDetailedDTO(MarketDTO marketDTO, GameDTO gameDTO){
        if (marketDTO == null || gameDTO == null) {
            return null;
        }

        return DetailedGameDTO.builder()
                .id(gameDTO.getId())
                .reference(gameDTO.getReference())
                .title(gameDTO.getTitle())
                .imageUrl(gameDTO.getImageUrl())
                .releaseDate(gameDTO.getReleaseDate())
                .genres(gameDTO.getGenres())
                .developer(gameDTO.getDeveloper() == null ? null : GameDTO.DeveloperDTO.builder().reference(gameDTO.getDeveloper().getReference()).name(gameDTO.getDeveloper().getName()).build())
                .editor(gameDTO.getEditor() == null ? null : GameDTO.EditorDTO.builder().reference(gameDTO.getEditor().getReference()).name(gameDTO.getEditor().getName()).build())
                .price(marketDTO.getPrice())
                .stock(marketDTO.getStock())
                .promotion(marketDTO.getPromotion())
                .download(marketDTO.getDownload())
                .build();
    }
}
