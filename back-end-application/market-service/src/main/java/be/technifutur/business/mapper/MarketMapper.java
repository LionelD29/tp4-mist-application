package be.technifutur.business.mapper;

import org.springframework.stereotype.Service;
import be.technifutur.model.dto.MarketDto;
import be.technifutur.model.entity.Market;
import be.technifutur.model.form.MarketForm;

import java.util.UUID;

@Service
public class MarketMapper {

    /**
     *
     * @param entity object
     * @return marketDto object. null if param is null
     */
    public MarketDto entityToDTO(Market entity) {
        if (entity == null) {
            return null;
        }
        return MarketDto.builder()
                .gameRef(entity.getGameRef())
                .price(entity.getPrice())
                .stock(entity.getStock())
                .promotion(entity.getPromotion())
                .build();
    }

    /**
     *
     * @param form object
     * @return Market entity object. null if param is null
     */
    public Market formToEntity(MarketForm form) {
        if (form == null) {
            return null;
        }
        return Market.builder()
                .gameRef(UUID.randomUUID())
                .price(form.getPrice())
                .stock(form.getStock())
                .promotion(form.getPomotion() != null ? form.getPomotion() : 0)
                .build();
    }
}
