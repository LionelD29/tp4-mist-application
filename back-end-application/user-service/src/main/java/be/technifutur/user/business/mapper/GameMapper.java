package be.technifutur.user.business.mapper;

import be.technifutur.user.model.dto.GameDTO;
import be.technifutur.user.model.entity.Game;
import org.springframework.stereotype.Service;

@Service
public class GameMapper {

    public GameDTO entityToDTO(Game entity) {
        if (entity == null)
            return null;
        return GameDTO.builder()
                .ref(entity.getRef())
                .build();
    }

}
