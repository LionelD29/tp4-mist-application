package be.technifutur.game.config;

import be.technifutur.shared.model.security.JwtValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public JwtValidationFilter jwtValidationFilter(){
        return new JwtValidationFilter(restTemplate(), "10.27.1.17", 8181); //chez moi, changer le authService en "localhost"
    }
}
