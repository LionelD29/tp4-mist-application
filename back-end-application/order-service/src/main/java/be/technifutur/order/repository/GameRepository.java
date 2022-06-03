package be.technifutur.order.repository;

import be.technifutur.order.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByGameReference(UUID gameReference);

}
