package be.technifutur.user.config;

import be.technifutur.shared.model.security.JwtValidationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BeanConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public JwtValidationFilter jwtValidationFilter(RestTemplate restTemplate) {
        return new JwtValidationFilter(restTemplate, "localhost", 8181);
    }

}
