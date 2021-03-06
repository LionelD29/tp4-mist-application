package be.technifutur.game.models.forms;

import be.technifutur.game.models.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameInsertForm {

    private double price;
    private int promotion;
    private String imageUrl;
    private String title;
    private LocalDate releaseDate;
    private List<Genre> genres;
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
