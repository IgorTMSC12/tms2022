package task3;

public class Skirt extends Clothes implements IWomensClothing {


    public Skirt(ClothingSizeType clothingSizeType, int price, String color) {
        super(clothingSizeType, price, color);
    }

    @Override
    public void dressWomen() {
        String result = "Юбка одета на женщину." + " Размер " + getClothingSizeType() + ", цена " + getPrice() +
                ", цвет " + getColor();
        System.out.println(result);
    }
}
