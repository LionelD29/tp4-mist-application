package be.technifutur.game.models.dto;

import be.technifutur.game.models.entities.Genre;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class DetailedGameDTO {

    private Long id;
    private UUID reference;
    private String title;
    private LocalDate releaseDate;
    private List<Genre> genres;
    private DeveloperDTO developer;
    private EditorDTO editor;
    private double price;
    private int stock;
    private int promotion;
}
