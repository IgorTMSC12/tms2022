package task4;

public class Apricot extends Fruit {

    public Apricot(double weight) {
        super(weight);
    }

    @Override
    double fruitCost() {
        double result = getWeight() * 3.5;
        return result;
    }
}
