package mk.ukim.finki.wp.supplement_shop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(long id) {
        super(String.format("Product with id: '%d' was not found", id));
    }

}
