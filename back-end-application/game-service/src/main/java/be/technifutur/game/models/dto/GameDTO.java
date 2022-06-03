package be.technifutur.game.models.dto;

import be.technifutur.game.models.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class GameDTO {

    private Long id;
    private UUID reference;
    private String title;
    private LocalDate releaseDate;
    private List<Genre> genres;
//    private Double price;
    private DeveloperDTO developer;
    private EditorDTO editor;


    @Data
    @AllArgsConstructor
    public static class DeveloperDTO{
        private UUID reference;
        private String name;
    }

    @Data
    @AllArgsConstructor
    public static class EditorDTO{
        private UUID reference;
        private String name;
    }
}
