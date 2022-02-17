package robot.hands;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SonyHand implements IHand {
    private int price;

    @Override
    public void upHand() {
        System.out.println("Рука поднята, Sony");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
