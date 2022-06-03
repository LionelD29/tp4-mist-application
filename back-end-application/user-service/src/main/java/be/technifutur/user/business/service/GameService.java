package be.technifutur.user.business.service;

import be.technifutur.user.business.mapper.GameMapper;
import be.technifutur.user.model.dto.GameDTO;
import be.technifutur.user.model.entity.User;
import be.technifutur.user.repository.GameRepository;
import be.technifutur.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
                        () -> new UsernameNotFoundException("User with ref '" + ref + "' not found")
                );
    }

    public List<GameDTO> getUserWishlist(UUID userRef) {
        return findUserByRef(userRef).getWishlist()
                .stream()
                .map(gameMapper::entityToDTO)
                .toList();
    }
}
