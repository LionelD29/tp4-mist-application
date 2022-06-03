package be.technifutur.game.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

//@FeignClient(name = "market-service")
//public interface MarketClient {
//
//    @GetMapping(path = "/market/price", params = "reference")
//    Double getGamePrice(@RequestParam(name = "reference") UUID reference);
//
//    @GetMapping(path = "/market/quantity", params = "reference")
//    int getGameQuantity(@RequestParam(name = "reference") UUID reference);
//
//    @GetMapping(path = "/market/promotion", params = "reference")
//    int getGamePromotion(@RequestParam(name = "reference") UUID reference);
//
//}
