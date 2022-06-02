package be.technifutur.user.business.service;

import be.technifutur.user.business.mapper.UserMapper;
import be.technifutur.user.model.dto.UserDTO;
import be.technifutur.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserDTO getUserInfo(UUID userRef) {
        return userRepository.findByRef(userRef)
                .map(userMapper::entityToDTO)
                .orElseThrow(
                        () -> new UsernameNotFoundException("User with ref '" + userRef + "' not found")
                );
    }
}
