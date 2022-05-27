package be.technifutur.auth.controller;

import be.technifutur.auth.business.service.SignInService;
import be.technifutur.auth.business.service.UserAccountService;
import be.technifutur.auth.model.dto.SimpleUserAccountDTO;
import be.technifutur.auth.model.form.SignInForm;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final SignInService signInService;
    private final UserAccountService userAccountService;

    @PostMapping("/sign-in")
    public String signIn(@Valid @RequestBody SignInForm form) {
        return signInService.signIn(form);
    }

    @GetMapping("/roles")
    @PreAuthorize("isAuthenticated()")
    public SimpleUserAccountDTO getUserRoles(Authentication auth) {
        return userAccountService.getUserRoles((String) auth.getPrincipal());
    }

}
