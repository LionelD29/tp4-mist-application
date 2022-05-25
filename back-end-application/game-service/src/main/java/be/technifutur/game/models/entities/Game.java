package be.technifutur.game.models.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long id;

    @Column(name = "reference", nullable = false)
    private UUID reference;

    @Column(name = "title", length = 150, nullable = false)
    private String title;

    @Column(name = "releaseDate")
    private LocalDate releaseDate;

    @Column(name = "genre")
    private Genre genre;

    @ManyToOne
    @JoinColumn
    private Editor editor;

    @ManyToOne
    @JoinColumn
    private Developer developer;

}
