package task3;

public class Trousers extends Clothes implements IMensClothing, IWomensClothing {

    public Trousers(ClothingSizeType clothingSizeType, int price, String color) {
        super(clothingSizeType, price, color);
    }

    @Override
    public void dressMan() {
        String result = "Штаны одеты на мужчину." + " Размер " + getClothingSizeType() + ", цена " + getPrice() +
                ", цвет " + getColor();
        System.out.println(result);
    }

    @Override
    public void dressWomen() {
        String result = "Штаны одеты на женщину." + " Размер " + getClothingSizeType() + ", цена " + getPrice() +
                ", цвет " + getColor();
        System.out.println(result);
    }

}
