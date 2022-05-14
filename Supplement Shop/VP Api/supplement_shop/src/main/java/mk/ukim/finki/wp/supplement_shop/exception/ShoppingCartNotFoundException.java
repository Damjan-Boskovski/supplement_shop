package mk.ukim.finki.wp.supplement_shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ShoppingCartNotFoundException extends RuntimeException{

    public ShoppingCartNotFoundException() {
        super("Shopping cart not found exception!");
    }
}
