package mk.ukim.finki.wp.supplement_shop.service.impl;

import mk.ukim.finki.wp.supplement_shop.exception.InvalidUserCredentialsException;
import mk.ukim.finki.wp.supplement_shop.model.User;
import mk.ukim.finki.wp.supplement_shop.repository.UserRepository;
import mk.ukim.finki.wp.supplement_shop.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;

    public AuthServiceImpl(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    @Override
    public User login(String email, String password) {
        if (email == null || email.isEmpty() || password == null || password.isEmpty())
            throw new IllegalArgumentException();

        User user = userRepository.findByEmail(email)
                .orElseThrow(InvalidUserCredentialsException::new);

        if (!encoder.matches(password, user.getPassword())) throw new InvalidUserCredentialsException();
        return user;

    }
}
