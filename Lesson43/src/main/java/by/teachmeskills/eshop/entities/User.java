package by.teachmeskills.eshop.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

    private String name;

    private String lastName;

    @NotEmpty(message = "Email must not be empty")
    @Email(message = "Email must be valid")
    private String email;

    @Size(min = 5, max = 30, message = "Password must be between 6 and 30 characters")
    @Pattern(regexp = "\\S+", message = "Spaces are not allowed")
    private String password;
}