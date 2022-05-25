package be.technifutur.game.repository;

import be.technifutur.game.models.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
