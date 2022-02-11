package tms.flowermarket;

public class Main {
    public static void main(String[] args) {
        FlowerMarket flowerMarket = new FlowerMarket();
        flowerMarket.getBouquet(Constants.LILY, Constants.ASTER, Constants.HERBERA);
        System.out.println(flowerMarket);

        FlowerMarket flowerMarket1 = new FlowerMarket();
        flowerMarket1.getBouquet(Constants.ROSE, Constants.TULIP, Constants.ROSE, Constants.ROSE);
        System.out.println(flowerMarket1);

        FlowerMarket flowerMarket2 = new FlowerMarket();
        flowerMarket2.getBouquet(Constants.LILY, Constants.ASTER, Constants.HERBERA);
        System.out.println(flowerMarket2);

        FlowerMarket flowerMarket3 = new FlowerMarket();
        flowerMarket3.getBouquet(Constants.ROSE, Constants.ROSE, Constants.ROSE, Constants.ROSE, Constants.ROSE);
        System.out.println(flowerMarket3);

        FlowerMarket flowerMarket4 = new FlowerMarket();
        flowerMarket4.getBouquet(Constants.LILY, Constants.LILY, Constants.LILY, Constants.LILY);
        System.out.println(flowerMarket4);
    }
}