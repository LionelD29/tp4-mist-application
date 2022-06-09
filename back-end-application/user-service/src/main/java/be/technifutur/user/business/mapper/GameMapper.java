package be.technifutur.user.business.mapper;

import be.technifutur.user.model.dto.GameDTO;
import be.technifutur.user.model.entity.Game;
import be.technifutur.user.model.form.GameForm;
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

    public Game formToEntity(GameForm form) {
        if (form == null)
            return null;
        return Game.builder()
                .ref(form.getRef())
                .build();
    }
}
