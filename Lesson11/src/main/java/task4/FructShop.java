package task4;

public class FructShop {

    public void priceFruct(Fruit[] fruits) {
        double sum = 0;
        for (int i = 0; i < fruits.length; i++) {
            double count = fruits[i].fruitCost();
            sum = sum + count;
        }
        String result = "Цена за все проданные фрукты " + sum + " рублей";
        System.out.println(result);
    }
}
