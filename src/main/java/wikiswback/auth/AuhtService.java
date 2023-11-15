package wikiswback.auth;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import wikiswback.User.UserEntity;
import wikiswback.User.UserRepository;

@Service
@RequiredArgsConstructor
public class AuhtService {

    private final UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public boolean checkPassword(String password, String hashedPassword) {
        return new BCryptPasswordEncoder().matches(password, hashedPassword);
    }
    public UserEntity login(AuthRequest authRequest) {

        UserEntity userEntity = userRepository.findByUsername(authRequest.getUsername())
                .orElseThrow(() -> new NotFoundException("User not found " + authRequest.getUsername()));

        if (!checkPassword(authRequest.getPassword(), userEntity.getPassword())) {
            throw new RuntimeException("Mot de passe incorrect");
        }

        System.out.println(userEntity);
       return userEntity;
    }
}
