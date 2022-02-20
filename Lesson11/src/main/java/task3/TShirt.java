package task3;

public class TShirt extends Clothes implements IMensClothing, IWomensClothing {

    public TShirt(ClothingSizeType clothingSizeType, int price, String color) {
        super(clothingSizeType, price, color);
    }


    @Override
    public void dressMan() {
        String result = "Футболка одета на мужчину." + " Размер " + getClothingSizeType() + ", цена " + getPrice() +
                ", цвет " + getColor();
        System.out.println(result);
    }

    @Override
    public void dressWomen() {
        String result = "Футболка одета на женщину." + " Размер " + getClothingSizeType() + ", цена " + getPrice() +
                ", цвет " + getColor();
        System.out.println(result);
    }
}
