package be.technifutur.filter;

import be.technifutur.model.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@AllArgsConstructor
public class JwtValidationFilter extends OncePerRequestFilter {
    private final RestTemplate restTemplate;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");
        try{
            token = token.replace("Bearer ", "");
            HttpHeaders headers = new HttpHeaders();
            headers.add("authorization", token);
            HttpEntity<Object> entity = new HttpEntity<>(headers);
            UserDTO userDTO = restTemplate
                    .exchange("http://auth-service:8181/auth", HttpMethod.GET, entity, UserDTO.class)
                    .getBody();
            if (userDTO != null) {
                Authentication auth = new UsernamePasswordAuthenticationToken(
                        userDTO.getUsername(),
                        "",
                        userDTO.getRoles().stream().map(SimpleGrantedAuthority::new).toList());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }

        }catch (Exception ignored){}
    }
}
