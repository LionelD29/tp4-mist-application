package be.technifutur.business.service;

import be.technifutur.business.mapper.MarketMapper;
import be.technifutur.exception.MarketPriceNotFoundException;
import be.technifutur.model.dto.MarketDto;
import be.technifutur.model.entity.Market;
import be.technifutur.model.form.MarketForm;
import be.technifutur.repo.MarketRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MarketService {

    private final MarketRepo repo;
    private final MarketMapper mapper;


    ////
    ///     CREATE METHOD
    /////////////////////////////////////////////
    public MarketDto addMarket(MarketForm form) {
        Market entity = mapper.formToEntity(form);
        repo.save(entity);
        return mapper.entityToDTO(entity);
    }

    ////
    ///     READ METHOD
    /////////////////////////////////////////////
    public MarketDto getOneByGameRef(UUID ref) {
        return repo.findByGameRef(ref)
                .map(mapper::entityToDTO)
                .orElseThrow(() -> new MarketPriceNotFoundException(ref, MarketDto.class));
    }
    public List<MarketDto> getAll(){
        return repo.findAll().stream()
                .map(mapper::entityToDTO)
                .toList();
    }

    ////
    ///     UPDATE METHOD
    /////////////////////////////////////////////
    public MarketDto updatePriceOnly(UUID ref, double price) {
        Market market = repo.findByGameRef(ref)
                .orElseThrow(() -> new MarketPriceNotFoundException(ref, MarketDto.class));
        market.setPrice(price);
        repo.save(market);
        return mapper.entityToDTO(market);
    }

    public MarketDto updateStockOnly(UUID ref, int stock) {
        Market market = repo.findByGameRef(ref)
                .orElseThrow(() -> new MarketPriceNotFoundException(ref, MarketDto.class));
        market.setStock(stock);
        repo.save(market);
        return mapper.entityToDTO(market);
    }

    public MarketDto updatePromotionOnly(UUID ref, int promo) {
        Market market = repo.findByGameRef(ref)
                .orElseThrow(() -> new MarketPriceNotFoundException(ref, MarketDto.class));
        market.setPromotion(promo);
        repo.save(market);
        return mapper.entityToDTO(market);
    }

    public MarketDto updateAll(UUID ref, MarketForm form) {
        Market market = repo.findByGameRef(ref)
                .orElseThrow(() -> new MarketPriceNotFoundException(ref, MarketDto.class));
        market.setStock(form.getStock());
        market.setPrice(form.getPrice());
        market.setPromotion(form.getPromotion() != null ? form.getPromotion() : 0);
        repo.save(market);
        return mapper.entityToDTO(market);
    }

    ////
    ///     DELETE METHOD
    /////////////////////////////////////////////
    public void deleteOneMarket(UUID ref){
        repo.deleteByGameRef(ref);
    }
}
