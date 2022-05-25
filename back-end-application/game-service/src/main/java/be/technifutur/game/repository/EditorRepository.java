package be.technifutur.game.repository;

import be.technifutur.game.models.entities.Editor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EditorRepository extends JpaRepository<Editor, Long> {
}
