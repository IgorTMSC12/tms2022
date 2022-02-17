package robot;

import lombok.NoArgsConstructor;
import robot.hands.SonyHand;
import robot.hands.ToshibaHand;
import robot.heads.SamsungHead;
import robot.heads.SonyHead;
import robot.heads.ToshibaHead;
import robot.legs.SamsungLeg;
import robot.legs.SonyLeg;
import robot.legs.ToshibaLeg;

@NoArgsConstructor
public class GenerateRobot {

    public Robot[] start() {
        SamsungHead samsungHead = new SamsungHead(20);
        ToshibaHand toshibaHand = new ToshibaHand(37);
        SonyLeg sonyLeg = new SonyLeg(24);
        Robot robot = new Robot(toshibaHand, samsungHead, sonyLeg);
        robot.action();
        System.out.println(robot.getPrice());

        System.out.println("-------------");

        ToshibaHead toshibaHead1 = new ToshibaHead(17);
        ToshibaHand toshibaHand1 = new ToshibaHand(37);
        SamsungLeg samsungLeg = new SamsungLeg(11);
        Robot robot1 = new Robot(toshibaHand1, toshibaHead1, samsungLeg);
        robot1.action();
        System.out.println(robot1.getPrice());

        System.out.println("-------------");

        SonyHead sonyHead = new SonyHead(44);
        SonyHand sonyHand = new SonyHand(21);
        ToshibaLeg toshibaLeg = new ToshibaLeg(35);
        Robot robot2 = new Robot(sonyHand, sonyHead, toshibaLeg);
        robot2.action();
        System.out.println(robot2.getPrice());

        Robot[] robots = new Robot[]{robot, robot1, robot2};
        return robots;
    }

    public void stoim(Robot[] robots) {
        int max = 0;
        for (int i = 0; i < robots.length; i++) {
            int sum = robots[i].getPrice();
            if (sum > max) {
                max = sum;
            }
        }
        String result = "Самый дорогой робот со стоимостью " + max;
        System.out.println(result);
    }
}
