package be.technifutur.game.metier.service.game;

import be.technifutur.game.models.dto.GameDTO;
import be.technifutur.game.models.forms.GameForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class GameServiceImpl implements GameService{
    @Override
    public List<GameDTO> getGames() {
        return null;
    }

    @Override
    public GameDTO getGameByReference(UUID reference) {
        return null;
    }

    @Override
    public GameDTO getGameByTitle(String title) {
        return null;
    }

    @Override
    public GameDTO insertGame(GameForm gameForm) {
        return null;
    }

    @Override
    public GameDTO updateGame(GameForm gameForm) {
        return null;
    }

    @Override
    public GameDTO deleteGame(UUID reference) {
        return null;
    }

    @Override
    public GameDTO updateDeveloperofGame(UUID gameReference, UUID devReference) {
        return null;
    }

    @Override
    public GameDTO updateEditorOfGame(UUID gameReference, UUID edReference) {
        return null;
    }
}
