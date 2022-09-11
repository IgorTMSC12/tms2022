package by.teachmeskills.eshop.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Product extends BaseEntity {

    private int categoryId;
    private String name;
    private String description;
    private int price;

}