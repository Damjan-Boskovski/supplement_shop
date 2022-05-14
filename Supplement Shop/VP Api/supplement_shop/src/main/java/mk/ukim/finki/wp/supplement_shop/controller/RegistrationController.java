package mk.ukim.finki.wp.supplement_shop.controller;

import mk.ukim.finki.wp.supplement_shop.model.dto.UserDto;
import mk.ukim.finki.wp.supplement_shop.model.User;
import mk.ukim.finki.wp.supplement_shop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> register(@RequestBody UserDto registrationRequest) {
        return userService.register(registrationRequest)
                .map(user -> ResponseEntity.ok().body(user))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

}
