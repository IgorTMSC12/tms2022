package by.teachmeskills.eshop.services;

import by.teachmeskills.eshop.dto.AuthResponse;
import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.exceptions.AuthorizationException;

public interface UserService {

    public AuthResponse authenticate(UserDto userDto) throws AuthorizationException;

    public UserDto create(UserDto userDto);
}
