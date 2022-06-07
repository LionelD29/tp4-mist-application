package be.technifutur.user.business.mapper;

import be.technifutur.shared.model.form.UserForm;
import be.technifutur.user.model.dto.UserDTO;
import be.technifutur.user.model.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class UserMapper {

    private final BillingAddressMapper billingAddressMapper;
    private final GameMapper gameMapper;

    public UserDTO entityToDTO(User entity) {
        if (entity == null)
            return null;

        return UserDTO.builder()
                .ref(entity.getRef())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .birthDate(entity.getBirthDate())
                .phoneNumber(entity.getPhoneNumber())
                .wallet(entity.getWallet())
                .loyaltyPoints(entity.getLoyaltyPoints())
                .wishlist(
                        entity.getWishlist()
                                .stream()
                                .map(gameMapper::entityToDTO)
                                .toList()
                )
                .billingAddresses(
                        entity.getBillingAddresses()
                                .stream()
                                .map(billingAddressMapper::entityToDTO)
                                .toList()
                )
                .build();
    }

    public User formToEntity(UserForm form) {
        if (form == null)
            return null;
        return User.builder()
                .ref(form.getRef())
                .firstName(form.getFirstName())
                .lastName(form.getLastName())
                .phoneNumber(form.getPhoneNumber())
                .birthDate(form.getBirthDate())
                .wallet(0)
                .loyaltyPoints(0)
                .wishlist(new ArrayList<>())
                .billingAddresses(new ArrayList<>())
                .build();
    }
}
