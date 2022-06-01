package be.technifutur.game.models.forms;

import be.technifutur.game.models.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GameUpdateForm {

    private String title;
    private LocalDate releaseDate;
    private List<Genre> genres;
}
