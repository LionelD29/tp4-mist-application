package be.technifutur.market.business.mapper;

import be.technifutur.shared.model.form.MarketForm;
import org.springframework.stereotype.Service;
import be.technifutur.market.model.dto.MarketDto;
import be.technifutur.market.model.entity.Market;

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
                .download(entity.getDownload())
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
                .gameRef(form.getGameRef())
                .price(form.getPrice())
                .stock(form.getStock())
                .promotion(form.getPromotion())
                .download(form.getDownload())
                .build();
    }
}
