package mk.ukim.finki.wp.supplement_shop.controller;

import mk.ukim.finki.wp.supplement_shop.exception.InvalidUserCredentialsException;
import mk.ukim.finki.wp.supplement_shop.model.User;
import mk.ukim.finki.wp.supplement_shop.model.dto.LoginRequest;
import mk.ukim.finki.wp.supplement_shop.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/login")
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public User login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest.getEmail(), loginRequest.getPassword());
    }


}
