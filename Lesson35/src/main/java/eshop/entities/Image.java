package eshop.entities;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Image extends BaseEntity {

    private int idCategory;
    private int idProduct;
    private String imagePath;

    public Image(int idCategory, int idProduct, String imagePath) {
        this.idCategory = idCategory;
        this.idProduct = idProduct;
        this.imagePath = imagePath;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public String getImagePath() {
        return imagePath;
    }

    public int getIdCategory() {
        return idCategory;
    }
}
