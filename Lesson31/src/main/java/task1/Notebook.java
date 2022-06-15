package task1;

public class Notebook implements Product {
    private String name;
    private int price;

    public Notebook(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public Product clone() {
        Notebook notebook = new Notebook(name, price);
        return notebook;
    }

    @Override
    public String toString() {
        return "Notebook{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
