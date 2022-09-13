package by.teachmeskills.eshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ProductDto {

    private int id;

    private int categoryId;

    private String name;

    private String description;

    private int price;
}
