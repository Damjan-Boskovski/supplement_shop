package mk.ukim.finki.wp.supplement_shop.service;

import mk.ukim.finki.wp.supplement_shop.model.User;

public interface AuthService {

    User login(String email, String password);

}
