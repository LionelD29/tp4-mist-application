package be.technifutur.order.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
@Table(name = "online_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private UUID userRef;

//    @NotBlank(message = "Buyer name must not be blank")
//    @Size(max = 50, message = "Buyer name must be 50 characters at maximum")
//    @Column(nullable = false, length = 50)
//    private String buyerName;

    @NotBlank(message = "Billing address must not be blank")
    @Size(max = 50, message = "Billing address must be 100 characters at maximum")
    @Column(nullable = false, length = 100)
    private String billingAddress;

    @PositiveOrZero(message = "Total price must not be negative")
    private int totalPrice;

    @NotNull(message = "Order date must not be null")
    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    // ORDER-GAME ENTITIES RELATIONSHIP
    @ManyToMany
    private List<Game> games;

}
