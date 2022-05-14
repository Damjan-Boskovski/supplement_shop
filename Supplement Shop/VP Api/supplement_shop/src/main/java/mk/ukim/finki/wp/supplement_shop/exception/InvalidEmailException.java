package mk.ukim.finki.wp.supplement_shop.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidEmailException extends RuntimeException{
    public InvalidEmailException() {
        super("Invalid email exception!");
    }
}
