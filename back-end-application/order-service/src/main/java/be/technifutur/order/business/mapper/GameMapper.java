package be.technifutur.order.business.mapper;

import be.technifutur.order.model.dto.OrderDTO;
import be.technifutur.order.model.entity.Game;
import be.technifutur.order.model.form.OrderForm;
import org.springframework.stereotype.Service;

@Service
public class GameMapper {

    public Game formToEntity(OrderForm.GameForm form) {
        if (form == null) {
            return null;
        }

        return Game.builder()
                .gameReference(form.getGameReference())
                .howMany(form.getHowMany())
                .build();
    }

    public OrderDTO.GameDTO entityToDTO(Game entity) {
        if (entity == null) {
            return null;
        }

        return OrderDTO.GameDTO.builder()
                .gameReference(entity.getGameReference())
                .howMany(entity.getHowMany())
                .build();
    }

}
