package be.technifutur.auth.business.mapper;

import be.technifutur.auth.model.dto.SimpleUserAccountDTO;
import be.technifutur.auth.model.entity.UserAccount;
import be.technifutur.auth.model.form.SignUpForm;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserAccountMapper {

    private final PasswordEncoder encoder;

    public SimpleUserAccountDTO entityToDTO(UserAccount entity) {
        if (entity == null)
            return null;

        return SimpleUserAccountDTO.builder()
                .ref(entity.getRef())
                .roles(entity.getRoles())
                .build();
    }

    public UserAccount formToEntity(SignUpForm form) {
        if (form == null)
            return null;

        return UserAccount.builder()
                .ref(UUID.randomUUID())
                .username(form.getUsername())
                .password(encoder.encode(form.getPassword()))
                .email(form.getEmail())
                .roles(List.of("USER"))
                .isAccountActive(true)
                .build();
    }
}
