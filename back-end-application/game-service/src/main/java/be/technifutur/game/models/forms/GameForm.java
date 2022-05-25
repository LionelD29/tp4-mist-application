package be.technifutur.game.models.forms;

import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
public class GameForm {

    private String title;
    private LocalDate releaseDate;
    private Genre genre;
    private Developer developer;
    private Editor editor;

    @Data
    @AllArgsConstructor
    public static class Developer {
        private Long id;
        private UUID reference;
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class Editor {
        private Long id;
        private UUID reference;
        private String name;
    }
}
