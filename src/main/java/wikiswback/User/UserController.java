package wikiswback.User;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import wikiswback.Jwt.JwtUtil;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @GetMapping
    List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    UserEntity getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }



    @PatchMapping("/{id}")
    UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {

        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
    }




}