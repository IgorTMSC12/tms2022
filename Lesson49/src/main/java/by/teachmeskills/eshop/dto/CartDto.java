package by.teachmeskills.eshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class CartDto {

    private List<ProductDto> products = new ArrayList<>();
    private int productsPrice;
    private int productsCount;

}