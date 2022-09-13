package by.teachmeskills.eshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class CategoryDto {

    private int id;

    private String name;

    private double rating;

    private List<ProductDto> products;
}
