package task5;

public class Triangle extends Figures implements IFigures {
    private int sizeA = 3;
    private int sizeB = 3;
    private int sizeC = 3;

    @Override
    public double getSquare() {
        double semiPerimetr = (double) (sizeA + sizeB + sizeC) / 2;
        double result = Math.sqrt(semiPerimetr * (semiPerimetr - sizeA) *
                (semiPerimetr - sizeB) * (semiPerimetr - sizeC));
        return result;
    }
}
