package be.technifutur.auth.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.jwt")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class JwtProperties {

    private String header;
    private String prefix;
    private long expiresAt;
    private String secret;

}
