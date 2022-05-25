package be.technifutur.game.repository;

import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.entities.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface EditorRepository extends JpaRepository<Editor, Long> {

    Optional<Editor> findByReference(UUID reference);
}
