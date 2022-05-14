package mk.ukim.finki.wp.supplement_shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("User not found exception!");
    }

    public UserNotFoundException(long id) {
        super(String.format("User with id: '%d' was not found", id));
    }

}
