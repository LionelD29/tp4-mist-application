package be.technifutur.auth.controller;

import be.technifutur.auth.business.service.SignInService;
import be.technifutur.auth.model.form.SignInForm;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final SignInService signInService;

    @PostMapping("/sign-in")
    public String signIn(@Valid @RequestBody SignInForm form) {
        return signInService.signIn(form);
    }

    @GetMapping("/test")
    @PreAuthorize("isAuthenticated()")
    public String test() {
        return "it works!";
    }

}
