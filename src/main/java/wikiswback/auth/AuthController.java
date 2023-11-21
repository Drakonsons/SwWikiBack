package wikiswback.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wikiswback.Jwt.JwtUtil;
import wikiswback.User.UserEntity;

import wikiswback.User.UserService;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;
    private final AuhtService auhtService;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    UserEntity createUser(@RequestBody UserEntity user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthRequest authRequest) {

        HashMap<String,Object> response = new HashMap<>();

        try{
            auhtService.login(authRequest); // check si le username existe, et s'il existe, récupérer l'objet USER en DB // et s'il est récupéré, comparer les MPD



            String token = jwtUtil.generateToken(authRequest);
            response.put("token",token);
            response.put("Request", "User logged in");
            return new ResponseEntity(response, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Login failed");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }


}
