package task4;

public class Pear extends Fruit {

    public Pear(double weight) {
        super(weight);
    }

    @Override
    double fruitCost() {
        double result = getWeight() * 7;
        return result;
    }
}
