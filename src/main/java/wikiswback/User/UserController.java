package wikiswback.User;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    List<UserEntity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    UserEntity getUserById(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @PostMapping
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
}
