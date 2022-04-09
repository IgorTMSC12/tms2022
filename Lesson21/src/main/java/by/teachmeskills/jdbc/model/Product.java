package by.teachmeskills.jdbc.model;

public class Product {
    private String name;
    private String info;
    private int price;
    private int count;
    private boolean availability;

    public Product(String name, String info, int price, int count, boolean availability) {
        this.name = name;
        this.info = info;
        this.price = price;
        this.count = count;
        this.availability = availability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", price=" + price +
                ", count=" + count +
                ", availability=" + availability +
                '}';
    }
}
