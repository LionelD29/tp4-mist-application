package be.technifutur.order.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Entity
@Builder
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID gameReference;

    @Positive
    private int quantity;

    // GAME-ORDER ENTITIES RELATIONSHIP
    @ManyToMany(mappedBy = "games")
    private List<Order> orders;

}
