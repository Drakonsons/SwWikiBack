package wikiswback.Security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wikiswback.Jwt.UserPrincipal;
import wikiswback.User.UserRepository;

@Service
public class UserDetailsServiceApp implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceApp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return new UserPrincipal(userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("can't find username " + username))
        );
    }

}
