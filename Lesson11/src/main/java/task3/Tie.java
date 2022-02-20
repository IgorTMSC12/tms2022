package task3;

public class Tie extends Clothes implements IMensClothing {

    public Tie(ClothingSizeType clothingSizeType, int price, String color) {
        super(clothingSizeType, price, color);
    }

    @Override
    public void dressMan() {
        String result = "Галстук одет на мужчину." + " Размер " + getClothingSizeType() + ", цена " + getPrice() +
                ", цвет " + getColor();
        System.out.println(result);
    }
}
