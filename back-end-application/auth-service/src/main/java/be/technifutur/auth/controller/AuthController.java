package be.technifutur.auth.controller;

import be.technifutur.auth.business.service.SignInService;
import be.technifutur.auth.business.service.UserAccountService;
import be.technifutur.auth.model.dto.UserAccountDTO;
import be.technifutur.auth.model.form.SignInForm;
import be.technifutur.auth.model.form.SignUpForm;
import be.technifutur.shared.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

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

    @PostMapping("/sign-up")
    public String signUp(@Valid @RequestBody SignUpForm form) {
        userAccountService.addUserAccount(form);
        SignInForm signInForm = new SignInForm(form.getEmail(), form.getPassword());
        return signInService.signIn(signInForm);
    }

    @GetMapping("/authenticate")
    @PreAuthorize("isAuthenticated()")
    public UserDTO authenticateUser(Authentication auth) {
        return userAccountService.getUserRoles((String) auth.getPrincipal());
    }

    @GetMapping("/account")
    @PreAuthorize("isAuthenticated()")
    public UserAccountDTO getUserAccount(Authentication auth) {
        return userAccountService.getUserAccount((String) auth.getPrincipal());
    }

    @PatchMapping("/toggle")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void toggleUserAccount(@RequestParam String userRef) {
        userAccountService.toggleUserAccount(UUID.fromString(userRef));
    }

    @PutMapping("/update")
    @PreAuthorize("isAuthenticated()")
    public void updateUserAccount(Authentication auth, @Valid @RequestBody SignUpForm form) {
        userAccountService.updateUserAccount((String) auth.getPrincipal(), form);
    }

}
