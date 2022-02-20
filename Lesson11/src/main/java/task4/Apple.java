package task4;

public class Apple extends Fruit {

    public Apple(double weight) {
        super(weight);
    }

    @Override
    double fruitCost() {
        double result = getWeight() * 5;
        return result;
    }
}
