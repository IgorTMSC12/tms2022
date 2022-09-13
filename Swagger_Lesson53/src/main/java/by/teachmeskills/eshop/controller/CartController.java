package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.dto.CartDto;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.Optional;

@Tag(name = "cart", description = "The cart API")
@RestController
@RequestMapping("/cart")
public class CartController {
    private CartServiceImpl cartService;
    private Cart cart = new Cart();

    public CartController(CartServiceImpl cartService) {
        this.cartService = cartService;
    }


    @Operation(
            summary = "Add products to cart",
            description = "Add products",
            tags = {"cart"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Products add to cart",
                    content = @Content(schema = @Schema(implementation = CartDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Products have not been added to the cart- Bad request"
            )
    })
    @PostMapping("/add")
    public ResponseEntity<CartDto> addProductToCart(@Min(value = 1) @RequestParam("productId") int id) {
        CartDto cartDtoResponse = cartService.addProductToCart(id, cart);
        if (Optional.ofNullable(cartDtoResponse).isPresent()) {
            return new ResponseEntity<>(cartDtoResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @Operation(
            summary = "Remove products from the cart",
            description = "Remove products from the cart",
            tags = {"cart"})
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Products have been removed from the cart",
                    content = @Content(schema = @Schema(implementation = CartDto.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Products have not been removed from the cart- Bad request"
            )
    })
    @PostMapping("/delete")
    public ResponseEntity<CartDto> deleteProductToCart(@Min(value = 1) @RequestParam("productId") int id) {
        CartDto cartDtoResponse = cartService.deleteProductToCart(id, cart);
        if (Optional.ofNullable(cartDtoResponse).isPresent()) {
            return new ResponseEntity<>(cartDtoResponse, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
    private ResponseEntity<OrderDto> createOrder(@RequestBody UserDto userDto) {
        OrderDto orderDto = cartService.createOrder(cart, userDto);
        if (Optional.ofNullable(orderDto).isPresent()) {
            return new ResponseEntity<>(orderDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
