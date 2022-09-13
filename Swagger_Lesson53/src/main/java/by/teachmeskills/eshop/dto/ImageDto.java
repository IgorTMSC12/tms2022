package by.teachmeskills.eshop.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ImageDto {

    private int id;

    private int categoryId;

    private int productId;

    private String imagePath;
}
