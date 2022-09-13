package by.teachmeskills.eshop.dto.convertes;

import by.teachmeskills.eshop.dto.CartDto;
import by.teachmeskills.eshop.entities.Cart;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CartConverter {
    private final ProductConverter productConverter;

    public CartConverter(ProductConverter productConverter) {
        this.productConverter = productConverter;
    }

    public CartDto toDto(Cart cart) {
        return Optional.ofNullable(cart).map(c -> CartDto.builder()
                        .products(Optional.ofNullable(c.getProducts()).map(products -> products
                                .stream().map(productConverter::toDto).toList()).orElse(List.of()))
                        .productsCount(c.getProductsCount())
                        .productsPrice(c.getProductsPrice())
                        .build()).
                orElse(null);
    }

    public Cart fromDto(CartDto cartDto) {
        return Optional.ofNullable(cartDto).map(cd -> Cart.builder()
                        .products(Optional.ofNullable(cd.getProducts()).map(products -> products
                                .stream().map(productConverter::fromDto).toList()).orElse(List.of()))
                        .productsCount(cd.getProductsCount())
                        .productsPrice(cd.getProductsPrice())
                        .build()).
                orElse(null);
    }

}
