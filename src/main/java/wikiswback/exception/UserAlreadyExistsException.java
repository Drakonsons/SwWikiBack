package wikiswback.exception;

import lombok.Getter;

@Getter
public class UserAlreadyExistsException extends RuntimeException {

    private final String username;
    private final String email;

    public UserAlreadyExistsException(String username, String email) {
        super(String.format("User with username %s or email %s already exists", username, email));
        this.username = username;
        this.email = email;
    }

}
