package clothes.shoes;

public class Ecco implements IShoes {
    @Override
    public void putOn() {
        System.out.println("Обувь обута, (Ecco)");
    }

    @Override
    public void takeOff() {
        System.out.println("Обувь снята, (Ecco)");
    }
}
