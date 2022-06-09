package be.technifutur.game.repository;

import be.technifutur.game.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findByReference(UUID reference);

    Optional<Game> findByTitle(String title);

    Optional<Game> deleteByReference(UUID reference);
}
