package be.technifutur.game.feign;

import be.technifutur.game.models.dto.MarketDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@FeignClient(name = "market-service")
public interface MarketClient {

    @GetMapping(path = "/market/all")
    List<MarketDTO> getAll();

    @GetMapping(path = "/market/{reference}")
    MarketDTO getOneByRef(@PathVariable(name = "reference") UUID reference);

}
