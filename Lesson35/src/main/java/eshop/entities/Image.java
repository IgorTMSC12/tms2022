package eshop.entities;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Image extends BaseEntity {

    private int categoryId;
    private int productId;
    private String imagePath;

    public Image(int categoryId, int productId, String imagePath) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.imagePath = imagePath;
    }

    public int getProductId() {
        return productId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
