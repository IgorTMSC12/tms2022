package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
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

@Tag(name = "UserCabinet", description = "The cabinet API")
@RestController
@RequestMapping("/cabinet")
public class UserCabinetController {
    private UserServiceImpl userService;

    public UserCabinetController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @Operation(
            summary = "Get user information and history of orders",
            description = "Get user information and history of orders",
            tags = {"cabinet"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Get user information",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Cant find user information"
            )
    })
    @PostMapping
    public ResponseEntity<UserDto> openUserCabinet(@RequestBody UserDto user) {
        UserDto userDto = userService.getUserCabinet(user);
        if (Optional.ofNullable(userDto).isPresent()) {
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
