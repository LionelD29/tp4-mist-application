package be.technifutur.game.models.forms;

import be.technifutur.game.models.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameInsertForm {

    private String title;
    private LocalDate releaseDate;
    private Genre genre;
    private Developer developer;
    private Editor editor;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Developer {
        private String name;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Editor {
        private String name;
    }
}
