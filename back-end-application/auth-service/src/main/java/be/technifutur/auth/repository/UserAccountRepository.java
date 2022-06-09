package be.technifutur.auth.repository;

import be.technifutur.auth.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    Optional<UserAccount> findByEmail(String email);
    Optional<UserAccount> findByRef(UUID ref);

}
