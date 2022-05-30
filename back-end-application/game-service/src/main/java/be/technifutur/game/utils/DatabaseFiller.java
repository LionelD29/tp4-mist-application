package be.technifutur.game.utils;

import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.entities.Game;
import be.technifutur.game.models.entities.Genre;
import be.technifutur.game.models.forms.GameForm;
import be.technifutur.game.repository.DeveloperRepository;
import be.technifutur.game.repository.EditorRepository;
import be.technifutur.game.repository.GameRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.UUID;

@Configuration
public class DatabaseFiller implements InitializingBean {

    private final GameRepository gameRepository;
    private final EditorRepository editorRepository;
    private final DeveloperRepository developerRepository;

    public DatabaseFiller(GameRepository gameRepository, EditorRepository editorRepository, DeveloperRepository developerRepository) {
        this.gameRepository = gameRepository;
        this.editorRepository = editorRepository;
        this.developerRepository = developerRepository;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        setUpListGame();
    }

    private void setUpListGame() throws Exception{
        Developer d = Developer.builder()
                .reference(UUID.randomUUID())
                .name("FromSoftware Inc.")
                .games(null)
                .build();
        developerRepository.save(d);

        Editor e = Editor.builder()
                .reference(UUID.randomUUID())
                .name("FromSoftware Inc.")
                .games(null)
                .build();
        editorRepository.save(e);

        Game g = Game.builder()
                .reference(UUID.randomUUID())
                .title("Elden Ring")
                .releaseDate(LocalDate.of(2022, 02, 25))
                .genre(Genre.RPG)
                .editor(e)
                .developer(d)
                .build();
        gameRepository.save(g);

        d = Developer.builder()
                .reference(UUID.randomUUID())
                .name("Shira Games")
                .games(null)
                .build();
        developerRepository.save(d);

        e = Editor.builder()
                .reference(UUID.randomUUID())
                .name("Funcom Shiro Games")
                .games(null)
                .build();
        editorRepository.save(e);

        g = Game.builder()
                .reference(UUID.randomUUID())
                .title("Dune - Spice wars")
                .releaseDate(LocalDate.of(2022, 04, 26))
                .genre(Genre.STRATEGY)
                .editor(e)
                .developer(d)
                .build();
        gameRepository.save(g);

        e = Editor.builder()
                .reference(UUID.randomUUID())
                .name("Mediatonic")
                .games(null)
                .build();
        editorRepository.save(e);

        d = Developer.builder()
                .reference(UUID.randomUUID())
                .name("Mediatonic")
                .games(null)
                .build();
        developerRepository.save(d);

        g = Game.builder()
                .reference(UUID.randomUUID())
                .title("Fall Guys - Sixth edition")
                .releaseDate(LocalDate.of(2020, 8, 04))
                .genre(Genre.MULTI)
                .editor(e)
                .developer(d)
                .build();
        gameRepository.save(g);
    }
}
