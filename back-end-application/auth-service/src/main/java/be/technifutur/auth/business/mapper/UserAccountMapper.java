package be.technifutur.auth.business.mapper;

import be.technifutur.auth.model.dto.SimpleUserAccountDTO;
import be.technifutur.auth.model.entity.UserAccount;
import org.springframework.stereotype.Service;

@Service
public class UserAccountMapper {

    public SimpleUserAccountDTO entityToDTO(UserAccount entity) {
        if (entity == null)
            return null;

        return SimpleUserAccountDTO.builder()
                .ref(entity.getRef())
                .roles(entity.getRoles())
                .build();
    }
}
