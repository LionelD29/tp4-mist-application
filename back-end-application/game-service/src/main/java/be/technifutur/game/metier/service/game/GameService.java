package be.technifutur.game.metier.service.game;

import be.technifutur.game.models.dto.DetailedGameDTO;
import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.forms.GameInsertForm;
import be.technifutur.game.models.forms.GameUpdateForm;

import java.util.List;
import java.util.UUID;

public interface GameService {

    List<GameDTO> getGames();

    DetailedGameDTO getGameByReference(UUID reference);

    GameDTO getGameByTitle(String title);

    GameDTO insertGame(GameInsertForm gameForm);

    GameDTO updateGame(UUID reference, GameUpdateForm gameForm);

    DetailedGameDTO deleteGame(UUID reference);

    GameDTO updateDeveloperOfGame(UUID gameReference, UUID devReference);

    GameDTO updateEditorOfGame(UUID gameReference, UUID edReference);
}
