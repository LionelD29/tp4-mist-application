package be.technifutur.controller;

import be.technifutur.business.service.MarketService;
import be.technifutur.model.dto.MarketDto;
import be.technifutur.model.form.MarketForm;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @DeleteMapping("/{ref}")
    public void deleteMarket(@PathVariable UUID ref) {
        service.deleteOneMarket(ref);
    }

    @PatchMapping("/update/price/{ref}")
    public MarketDto updatePriceOnly(@PathVariable UUID ref, @RequestParam double price) {
        return service.updatePriceOnly(ref, price);
    }

    @PatchMapping("/update/{ref}")
    public MarketDto updateStockOnly(@PathVariable UUID ref, @RequestParam int stock) {
        return service.updateStockOnly(ref, stock);
    }
    @PutMapping("/update/{ref}")
    public MarketDto updateAll(@PathVariable UUID ref,@Valid @RequestBody MarketForm form) {
        return service.updateAll(ref, form);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add")
    public MarketDto addMarket(@RequestBody MarketForm form) {
        return service.addMarket(form);
    }
}
