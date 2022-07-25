package eshop.entities;

import lombok.Data;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Data
@SuperBuilder
public class Category extends BaseEntity {

    private String name;
    private double rating;
    private List<Product> products = new ArrayList();
}

