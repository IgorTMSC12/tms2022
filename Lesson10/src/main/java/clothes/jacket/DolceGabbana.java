package clothes.jacket;

public class DolceGabbana implements IJacket {
    @Override
    public void putOn() {
        System.out.println("Куртка одета, (DolceGabbana)");
    }

    @Override
    public void takeOff() {
        System.out.println("Куртка снята, (DolceGabbana)");
    }
}
