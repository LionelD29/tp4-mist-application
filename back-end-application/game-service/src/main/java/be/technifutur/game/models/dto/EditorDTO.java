package be.technifutur.game.models.dto;

import be.technifutur.game.models.entities.Game;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class EditorDTO {

    private Long id;
    private UUID reference;
    private String name;
    private List<GameDTO> games;

    @Data
    public static class GameDTO{
        private final Long id;
        private final UUID reference;

        public static GameDTO of(Game entity){
            if (entity == null){
                return null;
            }
            return new GameDTO(entity.getId(), entity.getReference());
        }
    }
}
