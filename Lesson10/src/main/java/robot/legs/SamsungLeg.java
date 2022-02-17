package robot.legs;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SamsungLeg implements ILeg {
    private int price;

    @Override
    public void step() {
        System.out.println("Шаг Samsung");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
