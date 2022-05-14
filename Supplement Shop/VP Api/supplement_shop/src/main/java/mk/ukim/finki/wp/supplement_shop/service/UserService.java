package mk.ukim.finki.wp.supplement_shop.service;

import mk.ukim.finki.wp.supplement_shop.model.dto.UserDto;
import mk.ukim.finki.wp.supplement_shop.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    @Override
    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    Optional<User> register(UserDto registrationRequest);

    List<User> findAll();

    Optional<User> findById(Long id);

    public Optional<User> edit(Long id, UserDto userDetails);

    void deleteById(Long id);
}
