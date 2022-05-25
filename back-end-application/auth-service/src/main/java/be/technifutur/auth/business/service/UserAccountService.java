package be.technifutur.auth.business.service;

import be.technifutur.auth.repository.UserAccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserAccountService implements UserDetailsService {

    private final UserAccountRepository userAccountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userAccountRepository.findByEmail(email)
                .orElseThrow(
                        () -> new UsernameNotFoundException("There is no user with the email " + email)
                );
    }

}
