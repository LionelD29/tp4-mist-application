package be.technifutur.auth.business.service;

import be.technifutur.auth.config.JwtProperties;
import be.technifutur.auth.model.form.SignInForm;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
public class SignInService {

    private final AuthenticationManager authenticationManager;
    private final JwtProperties jwtProperties;

    public String signIn(SignInForm form) {

        Authentication auth = new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword());
        auth = authenticationManager.authenticate(auth);

        return JWT.create()
                .withSubject(form.getEmail())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + jwtProperties.getExpiresAt()))
                .withClaim(
                        "roles",
                        auth.getAuthorities()
                                .stream()
                                .map(GrantedAuthority::toString)
                                .toList()
                )
                .sign(Algorithm.HMAC512(jwtProperties.getSecret()));
    }
}
