package clothes.trousers;

public class AdidasTrousers implements ITrousers {
    @Override
    public void putOn() {
        System.out.println("Штаны одеты, (Adidas)");
    }

    @Override
    public void takeOff() {
        System.out.println("Штаны сняты, (Adidas)");
    }
}
