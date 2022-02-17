package tms.flowermarket;

import lombok.ToString;

@ToString
public class FlowerMarket {
    private Bouquet bouquet;

    public Bouquet getBouquet(String... flowers) {
        Flower[] newFlower = new Flower[flowers.length];
        for (int i = 0; i < flowers.length; i++) {
            String price = findPriceByFlowerName(flowers[i]);
            if (price != null) {
                Flower flower = new Flower(flowers[i], Integer.parseInt(price));
                newFlower[i] = flower;
            }
        }
        bouquet = new Bouquet(newFlower);
        return bouquet;
    }

    public String findPriceByFlowerName(String flower) {
        String price = null;
        for (int q = 0; q < Constants.flot.length; q++) {
            for (int j = 0; j < Constants.flot[q].length; j++) {
                if (flower.equals(Constants.flot[q][j])) {
                    price = Constants.flot[q + 1][j];
                }
            }
        }
        return price;
    }
}
