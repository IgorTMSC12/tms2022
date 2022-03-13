package task4;

public class Calcuator {

    public <T extends Number, V extends Number> double sum(T t, V v) {
        return t.doubleValue() + v.doubleValue();
    }

    public <T extends Number, V extends Number> double multiply(T t, V v) {
        return t.doubleValue() * v.doubleValue();
    }

    public <T extends Number, V extends Number> double divide(T t, V v) {
        return t.doubleValue() / v.doubleValue();
    }

    public <T extends Number, V extends Number> double subtraction(T t, V v) {
        return t.doubleValue() - v.doubleValue();
    }
}
