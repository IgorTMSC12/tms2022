package robot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import robot.hands.IHand;
import robot.heads.IHead;
import robot.legs.ILeg;

@Getter
@Setter
@AllArgsConstructor
public class Robot implements IRobot {
    private IHand hand;
    private IHead head;
    private ILeg leg;

    @Override
    public void action() {
        head.speak();
        hand.upHand();
        leg.step();
    }

    @Override
    public int getPrice() {
        int price = head.getPrice() + hand.getPrice() + leg.getPrice();
        return price;
    }
}
