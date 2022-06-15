package task2.model;

import java.util.List;

public class Category {
    private int idCategory;
    private String name;
    private String imageName;
    private List<Product> productList;

    public Category(int idCategory, String name, String imageName) {
        this.idCategory = idCategory;
        this.name = name;
        this.imageName = imageName;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
