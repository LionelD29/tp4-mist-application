package be.technifutur.user.controller;

import be.technifutur.shared.model.dto.BillingAddressDTO;
import be.technifutur.user.business.service.BillingAddressService;
import be.technifutur.user.business.service.GameService;
import be.technifutur.user.business.service.UserService;
import be.technifutur.user.model.dto.GameDTO;
import be.technifutur.user.model.dto.UserDTO;
import be.technifutur.user.model.form.BillingAddressForm;
import be.technifutur.user.model.form.GameForm;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final BillingAddressService billingAddressService;
    private final GameService gameService;

    @GetMapping("/details")
    @PreAuthorize("isAuthenticated()")
    public UserDTO getUserInfo(Authentication auth) {
        return userService.getUserInfo((UUID) auth.getPrincipal());
    }

    @GetMapping("/billing-address")
    @PreAuthorize("isAuthenticated()")
    public List<BillingAddressDTO> getUserBillingAddresses(Authentication auth) {
        return billingAddressService.getUserBillingAddresses((UUID) auth.getPrincipal());
    }

    @PostMapping("/billing-address/add")
    @PreAuthorize("isAuthenticated()")
    public void addBillingAddress(Authentication auth, @RequestBody BillingAddressForm form) {
        billingAddressService.addBillingAddress((UUID) auth.getPrincipal(), form);
    }

    @DeleteMapping("/billing-address/delete")
    @PreAuthorize("isAuthenticated()")
    public void deleteBillingAddress(Authentication auth, @RequestParam Long addressId) {
        billingAddressService.deleteBillingAddress((UUID) auth.getPrincipal(), addressId);
    }

    @GetMapping("/wishlist")
    @PreAuthorize("isAuthenticated()")
    public List<GameDTO> getUserWishlist(Authentication auth) {
        return gameService.getUserWishlist((UUID) auth.getPrincipal());
    }

    @PostMapping("/wishlist/add")
    @PreAuthorize("isAuthenticated()")
    public void addGameToWishlist(Authentication auth, @RequestBody GameForm form) {
        gameService.addGameToWishlist((UUID) auth.getPrincipal(), form);
    }

    @DeleteMapping("/wishlist/delete")
    @PreAuthorize("isAuthenticated()")
    public void deleteGameFromWishlist(Authentication auth, @RequestParam String gameRef) {
        gameService.deleteGameFromWishlist((UUID) auth.getPrincipal(), UUID.fromString(gameRef));
    }
}
