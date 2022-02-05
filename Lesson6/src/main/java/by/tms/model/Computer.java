package by.tms.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    private String cpu;
    private String ram;
    private String hd;
    private int count = 4;
    private boolean burned = false;

    public Computer(String cpu, String ram, String hd) {
        this.cpu = cpu;
        this.ram = ram;
        this.hd = hd;
    }

    public void info() {
        System.out.println(cpu + '\n' + ram + '\n' + hd + '\n' + "Число полных циклов " + count);
    }

    public void on() {
        if (burned == false || count != 0) {
            System.out.println("Внимание! Введите 0 или 1");
            Random random = new Random();
            int a = random.nextInt(2);
            Scanner scanner = new Scanner(System.in);
            int b = scanner.nextInt();
            if (a == b) {
                off();
            } else {
                System.out.println("Компьютер сгорел");
                burned = true;
            }
        } else {
            System.out.println("Компьютер сгорел");
        }


    }

    public void off() {
        if (count == 0) {
            System.out.println("Компьютер сгорел");
            burned = true;
        }
        if (burned == false) {
            System.out.println("Компьютер выключается");
            count--;
            on();
        }
    }
}
