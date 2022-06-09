package be.technifutur.user.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @NotNull
    @Column(nullable = false, unique = true)
    private UUID ref;

    @ManyToMany(mappedBy = "wishlist")
    private List<User> users = new ArrayList<>();

}
