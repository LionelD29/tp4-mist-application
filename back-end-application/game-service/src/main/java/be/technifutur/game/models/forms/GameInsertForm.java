package be.technifutur.game.models.forms;

import be.technifutur.game.models.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameInsertForm {

    private String title;
    private LocalDate releaseDate;
    private Set<Genre> genres;
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
