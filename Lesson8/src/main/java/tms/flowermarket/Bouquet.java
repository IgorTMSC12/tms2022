package tms.flowermarket;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
public class Bouquet {
    private Flower[] flower;

    public int summPrice(Flower[] flowers) {
        int summ = 0;
        for (int i = 0; i < flowers.length; i++) {
            summ += flowers[i].getPrice();
        }
        return summ;
    }

    @Override
    public String toString() {
        return "Bouquet{" +
                "priceBouquet=" + summPrice(flower) +
                " flowers=" + Arrays.toString(flower) +
                '}';
    }
}
