package be.technifutur.order.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID gameReference;

    // GAME-ORDER ENTITIES RELATIONSHIP
    @ManyToMany(mappedBy = "gamesToOrder")
    private List<Order> orders;

}
