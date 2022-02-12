package tms.flowermarket;

public class FlowerMarket {
    private Bouquet bouquet;

    public Bouquet getBouquet(String... flowers) {
        String[] massFlowers = flowers;
        Flower[] newFlower = new Flower[massFlowers.length];
        for (int i = 0; i < massFlowers.length; i++) {
            for (int q = 0; q < Constants.flot.length; q++) {
                for (int j = 0; j < Constants.flot[q].length; j++) {
                    if (massFlowers[i].equals(Constants.flot[q][j])) {
                        Flower flower = new Flower(Constants.flot[q][j], Integer.parseInt(Constants.flot[q + 1][j]));
                        newFlower[i] = flower;
                    }
                }
            }
        }
        bouquet = new Bouquet(newFlower);
        return bouquet;
    }

    @Override
    public String toString() {
        return "FlowerMarket{" +
                bouquet +
                '}';
    }
}
