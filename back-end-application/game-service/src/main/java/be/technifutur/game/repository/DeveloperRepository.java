package be.technifutur.game.repository;

import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {

    Optional<Developer> findByReference(UUID reference);

    Optional<Developer> findByName(String name);

    Optional<Developer> deleteByReference(UUID reference);
}
