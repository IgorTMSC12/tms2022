package robot.heads;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ToshibaHead implements IHead {
    private int price;

    @Override
    public void speak() {
        System.out.println("Говорит голова Toshiba");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
