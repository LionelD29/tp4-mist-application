package be.technifutur.game.models.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "reference", nullable = false)
    private UUID reference;

    @NotNull
    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @NotNull
    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private List<Genre> genres = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    private Editor editor;

    @ManyToOne
    @JoinColumn
    private Developer developer;

}
