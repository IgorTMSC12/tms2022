package clothes.shoes;

public class Crocs implements IShoes {
    @Override
    public void putOn() {
        System.out.println("Обувь обута, (Crocs)");
    }

    @Override
    public void takeOff() {
        System.out.println("Обувь снята, (Crocs)");
    }
}
