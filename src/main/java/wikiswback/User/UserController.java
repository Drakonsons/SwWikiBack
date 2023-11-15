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

    @PostMapping("/register")
    UserEntity createUser(@RequestBody UserEntity user) {

        return userService.createUser(user);
    }

    @PatchMapping("/{id}")
    UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {

        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<UserEntity> login(@RequestBody UserEntity user) {
        UserEntity userEntity = userRepository.findByUsername(user.getUsername()).orElseThrow();

        HashMap<String,Object> response = new HashMap<>();
        try{
            String token= jwtUtil.generateToken(userEntity);
            response.put("token",token);
            response.put("user",userEntity);
            return new ResponseEntity(response,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Login failed");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
       /* if (userEntity.getPassword().equals(passwordEncoder().encode(user.getPassword()))) {
            System.out.println("Login successful");
            return new ResponseEntity<>(userEntity, HttpStatus.OK);
        } else {
            System.out.println("Login failed");
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }*/
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}