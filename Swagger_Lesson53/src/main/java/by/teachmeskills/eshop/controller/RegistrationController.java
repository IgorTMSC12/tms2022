package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.config.JwtProvider;
import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(name = "registration", description = "The registration API")
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private UserServiceImpl userService;
    private JwtProvider jwtProvider;

    public RegistrationController(UserServiceImpl userService, JwtProvider jwtProvider) {
        this.userService = userService;
        this.jwtProvider = jwtProvider;
    }


    @Operation(
            summary = "Register user",
            description = "Register user",
            tags = {"register"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "User has been registered",
                    content = @Content(schema = @Schema(implementation = UserDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Could not register user"
            )
    })
    @PostMapping
    public ResponseEntity<UserDto> registerNewUser(@RequestBody UserDto userDto) {
        UserDto newUser = userService.create(userDto);
        if (Optional.ofNullable(newUser).isPresent()) {
            return new ResponseEntity<>(newUser, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
