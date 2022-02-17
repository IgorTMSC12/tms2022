package spaceport;

import java.util.Random;
import java.util.Scanner;

public class SpaceX implements IStart {

    @Override
    public boolean launchSystemCheck() {
        boolean check = true;
        System.out.println("Введите 0 или 1");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int number = scanner.nextInt();
            Random random = new Random();
            int number1 = random.nextInt(2);
            if (number == number1) {
                check = true;
            } else {
                check = false;
            }
        } else {
            System.out.println("Ошибка. Попробуйте ещё раз");
        }
        return check;
    }

    @Override
    public void engineStart() {
        System.out.println("Двигатели SpaceX запущены." + "\n" + "Все системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт SpaceX");
    }
}
