package task5;

public class Rectangle extends Figures implements IFigures {
    private int sizeA = 5;
    private int sizeB = 8;


    @Override
    public double getSquare() {
        int result = sizeA * sizeB;
        return result;
    }
}
