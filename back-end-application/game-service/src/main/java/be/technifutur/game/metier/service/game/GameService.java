package be.technifutur.game.metier.service.game;

import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.forms.GameForm;

import java.util.List;
import java.util.UUID;

public interface GameService {

    List<GameDTO> getGames();

    GameDTO getGameByReference(UUID reference);

    GameDTO getGameByTitle(String title);

    GameDTO insertGame(GameForm gameForm);

    GameDTO updateGame(GameForm gameForm);

    GameDTO deleteGame(UUID reference);

    GameDTO updateDeveloperofGame(UUID gameReference, UUID devReference);

    GameDTO updateEditorOfGame(UUID gameReference, UUID edReference);
}
