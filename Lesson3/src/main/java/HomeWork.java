import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        int[] array = {1, 2, 3, 4, 5};
        int[] array1 = {1, 2, 10, 3};
        System.out.println(task6(array));
        System.out.println(task7(array1));
    }

    public static void task1() {
        int b = 91;
        for (int i = 65; i < b; i++) {
            System.out.println((char) i);
        }
    }

    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число: ");
        double a = scanner.nextDouble();
        double b = a % 1;
        if (b > 0) {
            System.out.println("Ошибка: Введённое число " + a + " не является целым.");
        } else {
            int c = (int) a % 2;
            if (c == 1) {
                System.out.println("Введённое число " + (int) a + " является нечётным");
            } else {
                System.out.println("Введённое число " + (int) a + " является чётным");
            }
        }
    }

    public static void task3() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введеите три целых числа: ");
        int a = scanner1.nextInt();
        int b = scanner1.nextInt();
        int c = scanner1.nextInt();
        if (a < b & a < c) {
            System.out.println("Наименьшее из трёх введённых чисел: " + a);
        }
        if (b < a & b < c) {
            System.out.println("Наименьшее из трёх введённых чисел: " + b);
        }
        if (c < a & c < b) {
            System.out.println("Наименьшее из трёх введённых чисел: " + c);
        }
    }

    public static void task4() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Введите случайнное (на время тестирование) целое число из [0;28800]");
        int a = scanner3.nextInt();
        if (a > 28800) {
            System.out.println("Введённое число " + a + " превышает диапазон [0;28800]");
        } else {
            int b = a / 3600;
            if (b > 4) {
                System.out.println("Для Петрова: осталось " + a + " сек до конца рабочего дня");
                System.out.println("Для сотрудниц: осталось " + b + " часов до конца рабочего дня");
            }
            if (b > 1 & b < 5) {
                System.out.println("Для Петрова: осталось " + a + " сек до конца рабочего дня");
                System.out.println("Для сотрудниц: осталось " + b + " часа до конца рабочего дня");
            }
            if (b == 1) {
                System.out.println("Для Петрова: остался " + a + " сек до конца рабочего дня");
                System.out.println("Для сотрудниц: остался " + b + " час до конца рабочего дня");
            }
            if (b < 1) {
                System.out.println("Для Петрова: остался " + a + " сек до конца рабочего дня");
                System.out.println("Для сотрудниц: осталось меньше часа доконца рабочего дня");
            }
        }
    }

    public static void task5() {
        System.out.println("     " + " byte" + " short" + " char" + " int" + " long" + " float" + " double" + "boolean");
        System.out.println("byte" + "   т" + "    ня" + "    я" + "   ня" + "   ня" + "   ня" + "    ня" + "    x");
        System.out.println("short" + "  я" + "    т" + "     я" + "   ня" + "   ня" + "   ня" + "    ня" + "    х");
        System.out.println("char" + "   я" + "    я" + "     т" + "   я" + "    я" + "    я" + "     я" + "     х");
        System.out.println("int" + "    я" + "    я" + "     я" + "   т" + "    ня" + "   ня" + "    ня" + "    х");
        System.out.println("long" + "   я" + "    я" + "     я" + "   я" + "    т" + "    ня" + "    ня" + "    х");
        System.out.println("float" + "  я" + "    я" + "     я" + "   я" + "    я" + "    т" + "     я" + "     х");
        System.out.println("double" + " я" + "    я" + "     я" + "   я" + "    я" + "    я" + "     т" + "     х");
        System.out.println("boolean" + "х" + "    х" + "     х" + "   х" + "    х" + "    х" + "     х" + "     т");
    }

    public static double task6(int[] array) {
        double sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        double sr = sum / array.length;
        return sr;
    }

    public static int task7(int[] array1) {
        int max = 0;
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] > max) {
                max = array1[i];
            }
        }
        return max;
    }
}
