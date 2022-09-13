package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.dto.OrderDto;
import by.teachmeskills.eshop.dto.UserDto;
import by.teachmeskills.eshop.entities.Cart;
import by.teachmeskills.eshop.services.impl.CartServiceImpl;
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

@Tag(name = "order", description = "The order API")
@RestController
@RequestMapping("/order")
public class OrderController {
    private final CartServiceImpl cartService;

    public OrderController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }

    @Operation(
            summary = "Create order",
            description = "Create order",
            tags = {"cart"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully create order",
                    content = @Content(schema = @Schema(implementation = OrderDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Products have not been removed from the cart- Bad request"
            )
    })
    @PostMapping("/create")
    private ResponseEntity<OrderDto> createOrder(@RequestBody UserDto userDto, Cart cart) {
        OrderDto orderDto = cartService.createOrder(cart, userDto);
        if (Optional.ofNullable(orderDto).isPresent()) {
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
