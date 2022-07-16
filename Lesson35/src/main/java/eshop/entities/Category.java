package eshop.entities;

import lombok.experimental.SuperBuilder;

@SuperBuilder
public class Category extends BaseEntity {

    private String name;
    private double rating;

    public Category(int id, String name, double rating) {
        super(id);
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
