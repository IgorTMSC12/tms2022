package eshop.entities;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Product extends BaseEntity {

    private int idCategory;
    private String name;
    private String description;
    private int price;

    public Product(int id, int idCategory, String name, String description, int price) {
        super(id);
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
        this.price = price;
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
