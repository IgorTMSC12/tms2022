package eshop.entities;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Product extends BaseEntity {

    private int categoryId;
    private String name;
    private String description;
    private int price;

    public Product(int id, int categoryId, String name, String description, int price) {
        super(id);
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
