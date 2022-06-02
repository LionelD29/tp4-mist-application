package be.technifutur.user.model.dto;

import be.technifutur.user.model.entity.BillingAddress;
import be.technifutur.user.model.entity.Game;
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
public class UserDTO {

    private UUID ref;
    private String firstName;
    private String lastName;
    private double wallet;
    private int loyaltyPoints;
    private LocalDate birthDate;
    private String phoneNumber;
    private List<Game> wishlist = new ArrayList<>();
    private List<BillingAddress> billingAddresses = new ArrayList<>();

}
