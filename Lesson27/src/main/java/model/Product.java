package model;

public class Product {
    private int idCategory;
    private String imageName;
    private String name;
    private String description;
    private int price;

    public Product(int idCategory, String imageName, String name, String description, int price) {
        this.idCategory = idCategory;
        this.imageName = imageName;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return idCategory;
    }

    public void setId(int id) {
        this.idCategory = id;
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
