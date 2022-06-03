package be.technifutur.user.controller;

import be.technifutur.shared.model.dto.BillingAddressDTO;
import be.technifutur.user.business.service.BillingAddressService;
import be.technifutur.user.business.service.UserService;
import be.technifutur.user.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final BillingAddressService billingAddressService;

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

}
