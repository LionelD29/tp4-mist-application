package be.technifutur.auth.security;

import be.technifutur.auth.config.JwtProperties;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@Component
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProperties jwtProperties;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader(jwtProperties.getHeader());

        if (authorizationHeader != null) {
            authorizationHeader = authorizationHeader.replace(jwtProperties.getPrefix(), "");

            try {
                DecodedJWT jwt = JWT.require(Algorithm.HMAC512(jwtProperties.getSecret()))
                        .build()
                        .verify(authorizationHeader);

                if (jwt.getExpiresAt() != null && jwt.getExpiresAt().after(new Date())) {
                    Authentication auth = new UsernamePasswordAuthenticationToken(
                            jwt.getSubject(),
                            null,
                            jwt.getClaim("roles")
                                    .asList(String.class)
                                    .stream()
                                    .map(SimpleGrantedAuthority::new)
                                    .toList()
                    );
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            } catch (JWTVerificationException ignored) { }
        }
        filterChain.doFilter(request, response);
    }
}
