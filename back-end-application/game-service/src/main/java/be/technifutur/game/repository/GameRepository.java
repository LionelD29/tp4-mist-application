package be.technifutur.game.repository;

import be.technifutur.game.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
