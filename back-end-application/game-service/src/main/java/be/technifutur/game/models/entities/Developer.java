package be.technifutur.game.models.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id", nullable = false)
    private Long id;

    @Column(name = "reference", nullable = false)
    private UUID reference;

    @Column(name = "name", length = 150, nullable = false)
    private String name;

    @OneToMany(mappedBy = "developer", cascade = CascadeType.REFRESH)
    private List<Game> games = new ArrayList<>();
}
