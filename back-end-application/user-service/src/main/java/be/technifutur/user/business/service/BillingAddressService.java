package be.technifutur.user.business.service;

import be.technifutur.shared.model.dto.BillingAddressDTO;
import be.technifutur.user.business.mapper.BillingAddressMapper;
import be.technifutur.user.exception.ElementAlreadyExistsException;
import be.technifutur.user.exception.ElementNotFoundException;
import be.technifutur.user.model.entity.BillingAddress;
import be.technifutur.user.model.entity.User;
import be.technifutur.user.model.form.BillingAddressForm;
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

    private User findUserByRef(UUID userRef) {
        return userRepository.findByRef(userRef)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with ref '" + userRef + "' not found")
                );
    }

    private BillingAddress findAddressById(Long id) {
        return billingAddressRepository.findById(id)
                .orElseThrow(
                        () -> new ElementNotFoundException(BillingAddress.class.getSimpleName() + " with id '" + id + "' not found")
                );
    }

    public List<BillingAddressDTO> getUserBillingAddresses(UUID userRef) {

        User user = findUserByRef(userRef);

        return billingAddressRepository.findByUsers(user)
                .stream()
                .map(billingAddressMapper::entityToDTO)
                .toList();
    }

    public void addBillingAddress(UUID userRef, BillingAddressForm form) {
        User user = findUserByRef(userRef);
        BillingAddress address = billingAddressMapper.formToEntity(user, form);
        address = billingAddressRepository.save(address);
        if (user.getBillingAddresses().contains(address)) {
            throw new ElementAlreadyExistsException(
                    User.class.getSimpleName() + user.getFirstName() + " " + user.getLastName() + " already have the address " + address.getAddress()
            );
        }
        user.getBillingAddresses().add(address);
        userRepository.save(user);
    }

    public void deleteBillingAddress(UUID userRef, Long addressId) {
        User user = findUserByRef(userRef);
        BillingAddress address = findAddressById(addressId);
        user.getBillingAddresses().remove(address);
        userRepository.save(user);
        billingAddressRepository.delete(address);
    }
}
