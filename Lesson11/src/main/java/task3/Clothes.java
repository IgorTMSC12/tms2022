package task3;

public abstract class Clothes {
    private ClothingSizeType clothingSizeType;
    private int price;
    private String color;

    public Clothes(ClothingSizeType clothingSizeType, int price, String color) {
        this.clothingSizeType = clothingSizeType;
        this.price = price;
        this.color = color;
    }

    public ClothingSizeType getClothingSizeType() {
        return clothingSizeType;
    }

    public int getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Clothes{" +
                "clothingSizeType=" + clothingSizeType +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
