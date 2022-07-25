package eshop.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class Image extends BaseEntity {

    private int categoryId;
    private int productId;
    private String imagePath;
}
