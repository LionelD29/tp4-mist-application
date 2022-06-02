package be.technifutur.user.business.service;

import be.technifutur.user.repository.GameRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

}
