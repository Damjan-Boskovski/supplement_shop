package mk.ukim.finki.wp.supplement_shop.model.dto;

import lombok.Data;

@Data
public class LoginRequest {
    private final String email;
    private final String password;

    public LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
