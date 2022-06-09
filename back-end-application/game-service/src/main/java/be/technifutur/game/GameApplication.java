package be.technifutur.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

//@EnableFeignClients("game-service") //noter le nom du groupeId
@SpringBootApplication
public class GameApplication {
    public static void main(String[] args) {
        SpringApplication.run(GameApplication.class, args);
    }
}

