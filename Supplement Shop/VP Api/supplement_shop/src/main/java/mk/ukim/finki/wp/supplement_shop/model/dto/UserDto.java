package mk.ukim.finki.wp.supplement_shop.model.dto;

import lombok.Data;

@Data
public class UserDto {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String password;
    private final String repeatPassword;
    private final String userRole;

    public UserDto(String firstName, String lastName, String email, String password, String repeatPassword, String userRole) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.userRole = userRole;
    }
}
