package task4;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple(7);
        System.out.println("Цена за " + apple.getWeight() + " кг яблок - " + apple.fruitCost() + " рублей");

        Apricot apricot = new Apricot(4.56);
        System.out.println("Цена за " + apricot.getWeight() + " кг груш - " + apricot.fruitCost() + " рублей");

        Pear pear = new Pear(11.3);
        System.out.println("Цена за " + pear.getWeight() + " кг груш - " + pear.fruitCost() + " рублей");

        Fruit[] fruits = new Fruit[]{apple, apricot};

        FructShop fructShop = new FructShop();
        fructShop.priceFruct(fruits);

        // как округлить double до сотых?)

    }
}
