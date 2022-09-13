package by.teachmeskills.eshop.controller;

import by.teachmeskills.eshop.dto.CartDto;
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
}
