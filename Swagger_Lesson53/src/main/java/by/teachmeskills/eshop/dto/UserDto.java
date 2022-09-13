package by.teachmeskills.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder
public class UserDto {

    private int id;

    private String name;

    private String lastName;

    private String email;

    private String password;

    private String roleName;

    private List<OrderDto> orders;

}
