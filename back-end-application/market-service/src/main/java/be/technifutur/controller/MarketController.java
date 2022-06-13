package be.technifutur.controller;

import be.technifutur.business.service.MarketService;
import be.technifutur.model.dto.MarketDto;
import be.technifutur.model.form.MarketForm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@AllArgsConstructor
@RestController
@RequestMapping("market")
public class MarketController {

    private final MarketService service;


    @GetMapping("/check/{ref}/{quantity}")
    public boolean checkStockByQuantity(@PathVariable UUID ref, @PathVariable int quantity) {
        return service.getOneByGameRef(ref).getStock() >= quantity;
    }

    @GetMapping("/{ref}")
    public MarketDto getOneByRef(@PathVariable UUID ref) {
        return service.getOneByGameRef(ref);
    }
    @GetMapping("/all")
    public List<MarketDto> getAll(){
        return service.getAll();
    }


    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{ref}")
    public void deleteMarket(@PathVariable UUID ref) {
        service.deleteOneMarket(ref);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/update/price/{ref}")
    public MarketDto updatePriceOnly(@PathVariable UUID ref, @RequestParam double price) {
        return service.updatePriceOnly(ref, price);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/update/{ref}")
    public MarketDto updateStockOnly(@PathVariable UUID ref, @RequestParam int stock) {
        return service.updateStockOnly(ref, stock);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping("/update/promo/{ref}")
    public MarketDto updatePromotionOnly(@PathVariable UUID ref, @RequestParam int promotion) {
        return service.updatePromotionOnly(ref, promotion);
    }
    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping("/update/{ref}")
    public MarketDto updateAll(@PathVariable UUID ref,@Valid @RequestBody MarketForm form) {
        return service.updateAll(ref, form);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public MarketDto addMarket(@RequestBody MarketForm form) {
        return service.addMarket(form);
    }
}
