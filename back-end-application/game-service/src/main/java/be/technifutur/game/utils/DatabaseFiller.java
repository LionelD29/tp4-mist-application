package be.technifutur.game.utils;

import be.technifutur.game.models.entities.Developer;
import be.technifutur.game.models.entities.Editor;
import be.technifutur.game.models.entities.Game;
import be.technifutur.game.models.entities.Genre;
import be.technifutur.game.repository.DeveloperRepository;
import be.technifutur.game.repository.EditorRepository;
import be.technifutur.game.repository.GameRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
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
    public void afterPropertiesSet() {
//        setUpListGame();
    }

    private void setUpListGame() {
//        Developer d = Developer.builder()
//                .reference(UUID.randomUUID())
//                .name("FromSoftware Inc.")
//                .games(null)
//                .build();
//        developerRepository.save(d);
//
//        Editor e = Editor.builder()
//                .reference(UUID.randomUUID())
//                .name("FromSoftware Inc.")
//                .games(null)
//                .build();
//        editorRepository.save(e);
//
//        Game g = Game.builder()
//                .reference(UUID.fromString("195e9333-81db-43d3-8506-ed9467d3c6c4"))
//                .title("Elden Ring")
//                .imageUrl("image of ELDEN RING")
//                .releaseDate(LocalDate.of(2022, 2, 25))
//                .genres(List.of(Genre.RPG, Genre.SOLO))
//                .editor(e)
//                .developer(d)
//                .build();
//        gameRepository.save(g);
//
//        d = Developer.builder()
//                .reference(UUID.randomUUID())
//                .name("Shira Games")
//                .games(null)
//                .build();
//        developerRepository.save(d);
//
//        e = Editor.builder()
//                .reference(UUID.randomUUID())
//                .name("Funcom Shiro Games")
//                .games(null)
//                .build();
//        editorRepository.save(e);
//
//        g = Game.builder()
//                .reference(UUID.fromString("68cfd22f-799d-452d-8a09-7a292c41f010"))
//                .title("Dune - Spice wars")
//                .imageUrl("image of Dune - Spice Wars")
//                .releaseDate(LocalDate.of(2022, 4, 26))
//                .genres(List.of(Genre.STRATEGY, Genre.SOLO))
//                .editor(e)
//                .developer(d)
//                .build();
//        gameRepository.save(g);
//
//        e = Editor.builder()
//                .reference(UUID.randomUUID())
//                .name("Mediatonic")
//                .games(null)
//                .build();
//        editorRepository.save(e);
//
//        d = Developer.builder()
//                .reference(UUID.randomUUID())
//                .name("Mediatonic")
//                .games(null)
//                .build();
//        developerRepository.save(d);
//
//        g = Game.builder()
//                .reference(UUID.fromString("f15a67d5-65cb-40f7-87e5-0408d4fd5c28"))
//                .title("Fall Guys - Sixth edition")
//                .imageUrl("image of Fall Guys - Sixth edition")
//                .releaseDate(LocalDate.of(2020, 8, 4))
//                .genres(List.of(Genre.MULTI, Genre.ACTION))
//                .editor(e)
//                .developer(d)
//                .build();
//        gameRepository.save(g);
    }
}
