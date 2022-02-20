package robot;

import robot.hands.SonyHand;
import robot.hands.ToshibaHand;
import robot.heads.SamsungHead;
import robot.heads.SonyHead;
import robot.heads.ToshibaHead;
import robot.legs.SamsungLeg;
import robot.legs.SonyLeg;
import robot.legs.ToshibaLeg;

public class RobotUtils {

    public static Robot[] getRobots() {
        SamsungHead samsungHead = new SamsungHead(20);
        ToshibaHand toshibaHand = new ToshibaHand(37);
        SonyLeg sonyLeg = new SonyLeg(24);
        Robot robot = new Robot(toshibaHand, samsungHead, sonyLeg);

        ToshibaHead toshibaHead1 = new ToshibaHead(17);
        ToshibaHand toshibaHand1 = new ToshibaHand(37);
        SamsungLeg samsungLeg = new SamsungLeg(11);
        Robot robot1 = new Robot(toshibaHand1, toshibaHead1, samsungLeg);

        SonyHead sonyHead = new SonyHead(44);
        SonyHand sonyHand = new SonyHand(21);
        ToshibaLeg toshibaLeg = new ToshibaLeg(35);
        Robot robot2 = new Robot(sonyHand, sonyHead, toshibaLeg);

        Robot[] robots = new Robot[]{robot, robot1, robot2};
        return robots;
    }

    public static void maxPriceRobot(Robot[] robots) {
        int max = 0;
        for (int i = 0; i < robots.length; i++) {
            robots[i].action();
            System.out.println(robots[i].getPrice());
            int sum = robots[i].getPrice();
            if (sum > max) {
                max = sum;
            }
        }
        String result = "Самый дорогой робот со стоимостью " + max;
        System.out.println(result);
    }
}
