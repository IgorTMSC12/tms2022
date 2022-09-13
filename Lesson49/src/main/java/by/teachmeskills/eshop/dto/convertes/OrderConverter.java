package by.teachmeskills.eshop.dto.convertes;

import by.teachmeskills.eshop.dto.OrderDto;
import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.repositories.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class OrderConverter {

    private final ProductConverter productConverter;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public OrderConverter(ProductConverter productConverter, UserRepository userRepository, ProductRepository productRepository) {
        this.productConverter = productConverter;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public OrderDto toDto(Order order) {
        return Optional.ofNullable(order).map(o -> OrderDto.builder()
                        .id(o.getId())
                        .date(o.getOrderData())
                        .price(o.getOrderPrice())
                        .userId(o.getUser().getId())
                        .products(Optional.ofNullable(o.getProducts()).map(products -> products
                                .stream().map(productConverter::toDto).toList()).orElse(List.of()))
                        .build())
                .orElse(null);
    }

    public Order fromDto(OrderDto orderDto) {
        return Optional.ofNullable(orderDto).map(od -> Order.builder()
                        .id(od.getId())
                        .orderData(od.getDate())
                        .orderPrice(od.getPrice())
                        .user(userRepository.getById(od.getUserId()))
                        .build())
                .orElse(null);
    }

}
