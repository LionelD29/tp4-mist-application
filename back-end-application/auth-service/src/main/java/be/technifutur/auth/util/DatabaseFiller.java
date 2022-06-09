package be.technifutur.auth.util;

import be.technifutur.auth.model.entity.UserAccount;
import be.technifutur.auth.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class DatabaseFiller implements InitializingBean {

    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder encoder;

    @Override
    public void afterPropertiesSet() throws Exception {
        UserAccount user = UserAccount.builder()
                .ref(UUID.randomUUID())
                .username("lionel")
                .password(encoder.encode("pass"))
                .email("lionel@test.com")
                .isAccountActive(true)
                .roles(List.of("USER"))
                .build();
        userAccountRepository.save(user);

        UserAccount admin = UserAccount.builder()
                .ref(UUID.randomUUID())
                .username("admin")
                .password(encoder.encode("pass"))
                .email("admin@test.com")
                .isAccountActive(true)
                .roles(List.of("USER", "ADMIN"))
                .build();
        userAccountRepository.save(admin);
    }
}
