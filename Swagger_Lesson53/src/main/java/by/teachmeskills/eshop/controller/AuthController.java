package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.config.JwtProvider;
import by.teachmeskills.eshop.dto.AuthResponse;
import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.exceptions.AuthorizationException;
import by.teachmeskills.eshop.repositories.UserRepository;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "authentication", description = "The authentication API")
@Validated
@RestController
@RequestMapping("/login")
public class AuthController {

    private UserServiceImpl userService;
    private UserRepository userRepository;
    private JwtProvider jwtProvider;


    public AuthController(UserServiceImpl userService, JwtProvider jwtProvider, UserRepository userRepository) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
        this.userRepository = userRepository;
    }

    @Operation(
            summary = "Authorize user",
            description = "Authorize user",
            tags = {"login"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully logged in",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "User is not found"
            )
    })
    @PostMapping
    public AuthResponse login(@RequestBody UserDto userDto) throws AuthorizationException {
        AuthResponse authenticate = userService.authenticate(userDto);
        return authenticate;
    }
}
