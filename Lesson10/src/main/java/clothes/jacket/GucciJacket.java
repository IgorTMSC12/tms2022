package clothes.jacket;

public class GucciJacket implements IJacket {
    @Override
    public void putOn() {
        System.out.println("Куртка одета, (Gucci)");
    }

    @Override
    public void takeOff() {
        System.out.println("Куртка снята, (Gucci)");
    }
}
