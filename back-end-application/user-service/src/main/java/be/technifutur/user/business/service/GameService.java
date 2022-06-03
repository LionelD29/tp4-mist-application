package be.technifutur.user.business.service;

import be.technifutur.user.business.mapper.GameMapper;
import be.technifutur.user.exception.ElementAlreadyExistsException;
import be.technifutur.user.exception.ElementNotFoundException;
import be.technifutur.user.model.dto.GameDTO;
import be.technifutur.user.model.entity.Game;
import be.technifutur.user.model.entity.User;
import be.technifutur.user.model.form.GameForm;
import be.technifutur.user.repository.GameRepository;
import be.technifutur.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final GameMapper gameMapper;

    private User findUserByRef(UUID ref) {
        return userRepository.findByRef(ref)
                .orElseThrow(
                        () -> new ElementNotFoundException("User with ref '" + ref + "' not found")
                );
    }

    private Game findGameByRef(UUID ref) {
        return gameRepository.findByRef(ref)
                .orElseThrow(
                        () -> new ElementNotFoundException("Game with ref '" + ref + "' not found")
                );
    }

    public List<GameDTO> getUserWishlist(UUID userRef) {
        return findUserByRef(userRef).getWishlist()
                .stream()
                .map(gameMapper::entityToDTO)
                .toList();
    }

    public void addGameToWishlist(UUID userRef, GameForm form) {
        User user = findUserByRef(userRef);
        Game game;

        if (!gameRepository.existsByRef(form.getRef())) {
            game = gameMapper.formToEntity(form);
            game = gameRepository.save(game);
        } else {
            game = findGameByRef(form.getRef());
        }

        if (user.getWishlist().contains(game))
            throw new ElementAlreadyExistsException(Game.class.getSimpleName() + " element already present in ref=" + userRef + " user's wishlist");

        user.getWishlist().add(game);
        userRepository.save(user);

    }
}
