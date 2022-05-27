package be.technifutur.order.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "online_order")
public class OnlineOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false, unique = true)
    private UUID user_ref;

    @Column(nullable = false, length = 50)
    private String buyer_name;

    @Column(nullable = false, length = 100)
    private String shipping_address;

    private int totalPrice;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // ORDER-GAME ENTITIES RELATIONSHIP
    @ManyToMany
    private List<Game> gamesToOrder;

}
