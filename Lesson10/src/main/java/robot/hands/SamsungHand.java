package robot.hands;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SamsungHand implements IHand {
    private int price;

    @Override
    public void upHand() {
        System.out.println("Рука поднята, Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
