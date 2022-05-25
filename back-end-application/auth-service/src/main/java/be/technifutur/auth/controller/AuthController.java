package be.technifutur.auth.controller;

import be.technifutur.auth.business.service.SignInService;
import be.technifutur.auth.model.form.SignInForm;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
