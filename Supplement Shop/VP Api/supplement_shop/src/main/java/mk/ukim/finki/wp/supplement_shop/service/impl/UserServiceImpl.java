package mk.ukim.finki.wp.supplement_shop.service.impl;

import mk.ukim.finki.wp.supplement_shop.exception.*;
import mk.ukim.finki.wp.supplement_shop.model.dto.UserDto;
import mk.ukim.finki.wp.supplement_shop.model.User;
import mk.ukim.finki.wp.supplement_shop.model.enumerations.UserRole;
import mk.ukim.finki.wp.supplement_shop.repository.UserRepository;
import mk.ukim.finki.wp.supplement_shop.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> edit(Long id, UserDto userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        // if email has been changed, but there's already a user with that email throw exception
        if (!userDetails.getEmail().equals(user.getEmail())
                && userRepository.findByEmail(userDetails.getEmail()).isPresent())
            throw new UserAlreadyExistsException(userDetails.getEmail());

        if (!userDetails.getPassword().equals(userDetails.getRepeatPassword()))
            throw new PasswordsDoNotMatchException();

        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        user.setUserRole(userDetails.getUserRole());
        return Optional.of(userRepository.save(user));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(
                        String.format("User with email %s was not found!", email)
                ));
    }

    @Override
    public Optional<User> register(UserDto request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String email = request.getEmail();
        String password = request.getPassword();
        String repeatPassword = request.getRepeatPassword();
        UserRole userRole = UserRole.USER;
        if (request.getUserRole() != null && request.getUserRole().toUpperCase(Locale.ROOT).equals("ADMIN"))
             userRole = UserRole.ADMIN;

        if (userRepository.findByEmail(email).isPresent())
            throw new UserAlreadyExistsException(email);

        if (email == null || email.isEmpty())
            throw new InvalidEmailException();

        if (password == null || password.isEmpty())
            throw new InvalidPasswordException();

        if (password.equals(repeatPassword))
            throw new PasswordsDoNotMatchException();

        String encodedPassword = bCryptPasswordEncoder.encode(password);
        User user = new User(firstName, lastName, email, encodedPassword, userRole);
        return Optional.of(userRepository.save(user));
    }

}
