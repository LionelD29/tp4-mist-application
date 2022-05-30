package be.technifutur.game.repository;

import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findByReference(UUID reference);

    Optional<Game> findByTitle(String title);

    Optional<Game> deleteByReference(UUID reference);
}
