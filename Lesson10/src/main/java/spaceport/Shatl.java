package spaceport;

import java.util.Random;

public class Shatl implements IStart {

    @Override
    public boolean launchSystemCheck() {
        boolean check;
        Random random = new Random();
        int number = random.nextInt(11);
        if (number > 3) {
            check = true;
        } else {
            check = false;
        }
        return check;
    }

    @Override
    public void engineStart() {
        System.out.println("Двигатели Shatl запущены." + "\n" + "Все системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт Shatl");
    }
}
