package be.technifutur.user.repository;

import be.technifutur.user.model.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface GameRepository extends JpaRepository<Game, Long> {

    Optional<Game> findByRef(UUID ref);
    boolean existsByRef(UUID ref);

}
