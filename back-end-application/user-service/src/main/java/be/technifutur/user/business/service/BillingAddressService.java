package be.technifutur.user.business.service;

import be.technifutur.shared.model.dto.BillingAddressDTO;
import be.technifutur.user.business.mapper.BillingAddressMapper;
import be.technifutur.user.model.entity.User;
import be.technifutur.user.repository.BillingAddressRepository;
import be.technifutur.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class BillingAddressService {

    private final BillingAddressRepository billingAddressRepository;
    private final UserRepository userRepository;
    private final BillingAddressMapper billingAddressMapper;

    public List<BillingAddressDTO> getUserBillingAddresses(UUID userRef) {
        User user = userRepository.findByRef(userRef)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with ref '" + userRef + "' not found")
                );
        return billingAddressRepository.findByUsers(user)
                .stream()
                .map(billingAddressMapper::entityToDTO)
                .toList();
    }
}
