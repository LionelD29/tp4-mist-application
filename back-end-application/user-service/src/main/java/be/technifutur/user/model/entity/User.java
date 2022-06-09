package be.technifutur.user.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private UUID ref;

    @Size(max = 30)
    @NotBlank
    @Column(nullable = false, length = 30)
    private String firstName;

    @Size(max = 30)
    @NotBlank
    @Column(nullable = false, length = 30)
    private String lastName;

    @Min(0)
    private double wallet;

    @Min(0)
    private int loyaltyPoints;

    @Past
    @NotNull
    private LocalDate birthDate;

    @Size(max = 15)
    @Column(unique = true, length = 15)
    private String phoneNumber;

    @ManyToMany
    private List<Game> wishlist = new ArrayList<>();

    @ManyToMany
    private List<BillingAddress> billingAddresses = new ArrayList<>();

}
