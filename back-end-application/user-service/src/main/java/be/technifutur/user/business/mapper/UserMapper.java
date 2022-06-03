package be.technifutur.user.business.mapper;

import be.technifutur.user.model.dto.UserDTO;
import be.technifutur.user.model.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserMapper {

    private final BillingAddressMapper billingAddressMapper;

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
                .wishlist(entity.getWishlist())
                .billingAddresses(
                        entity.getBillingAddresses()
                                .stream()
                                .map(billingAddressMapper::entityToDTO)
                                .toList()
                )
                .build();
    }
}
