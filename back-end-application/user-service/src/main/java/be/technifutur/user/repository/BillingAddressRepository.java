package be.technifutur.user.repository;

import be.technifutur.user.model.entity.BillingAddress;
import be.technifutur.user.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {

    List<BillingAddress> findByUsers(User user);

}
