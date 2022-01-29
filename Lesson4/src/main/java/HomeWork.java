import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        printArray();
        System.out.println(operation(1));
        System.out.println(operation(0));
        System.out.println(calculateCountOfOddElementsInMatrix(new int[]{1, 2, 3, 4, 5, 6}));
        countDevs(103);
        countDevs(11);
        foobar(6);
        foobar(10);
        foobar(15);
        printPrimeNumbers();
    }

    public static void task1() {
        int values = (int) ((Math.random() * 7) + 1);
        switch (values) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6, 7:
                System.out.println("Выходной");
                break;
        }
    }

    public static void task2() {
        int ameb = 1;
        for (int i = 0; i <= 24; i += 3) {
            if (i > 0) {
                ameb = ameb * 2;
                System.out.println("Через " + i + " часа (часов, час) амёба разделилась на " + ameb + " амёб (амёбы)");
            }
        }
    }

    public static void task3() {
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите целое число");
        int values = scanner1.nextInt();
        if (values > 0) {
            System.out.println("Введённое число " + values + " является положительным");
        } else if (values < 0) {
            System.out.println("Введённое число " + values + " является отрицательным");
        } else {
            System.out.println("Введённое число " + values + " является ни положительным, ни отрицательным");
        }
        int numbers;
        int x = 0;
        do {
            values = Math.abs(values) / 10;
            numbers = values;
            x = x + 1;
        } while (!(numbers < 1));
        System.out.println("Колисество цифр в числе: " + x);
    }

    public static void task4() {
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Введите число Вашего дня рождения");
        int number_day = scanner2.nextInt();
        System.out.println("Введите число Вашего месяца вашего дня рождения");
        int number_moth = scanner3.nextInt();
        if (number_day <= 31 && number_moth <= 12 && number_day > 0 && number_moth > 0) {
            switch (number_moth) {
                case 1:
                    if (number_day >= 21) {
                        System.out.println("Ваш знак задиака водолей");
                    } else {
                        System.out.println("Ваш знак задиака Козерог");
                    }
                    break;
                case 2:
                    if (number_day >= 20) {
                        System.out.println("Ваш знак задиака рыба");
                    } else {
                        System.out.println("Ваш знак задиака водолей");
                    }
                    break;
                case 3:
                    if (number_day >= 21) {
                        System.out.println("Ваш знак задиака овен");
                    } else {
                        System.out.println("Ваш знак задиака рыба");
                    }
                    break;
                case 4:
                    if (number_day >= 21) {
                        System.out.println("Ваш знак задиака телец");
                    } else {
                        System.out.println("Ваш знак задиака овен");
                    }
                    break;
                case 5:
                    if (number_day >= 22) {
                        System.out.println("Ваш знак задиака близнецы");
                    } else {
                        System.out.println("Ваш знак задиака телец");
                    }
                    break;
                case 6:
                    if (number_day >= 22) {
                        System.out.println("Ваш знак задиака рак");
                    } else {
                        System.out.println("Ваш знак задиака близнецы");
                    }
                    break;
                case 7:
                    if (number_day >= 23) {
                        System.out.println("Ваш знак задиака лев");
                    } else {
                        System.out.println("Ваш знак задиака рак");
                    }
                    break;
                case 8:
                    if (number_day >= 22) {
                        System.out.println("Ваш знак задиака дева");
                    } else {
                        System.out.println("Ваш знак задиака лев");
                    }
                    break;
                case 9:
                    if (number_day >= 24) {
                        System.out.println("Ваш знак задиака весы");
                    } else {
                        System.out.println("Ваш знак задиака дева");
                    }
                    break;
                case 10:
                    if (number_day >= 24) {
                        System.out.println("Ваш знак задиака скорпион");
                    } else {
                        System.out.println("Ваш знак задиака весы");
                    }
                    break;
                case 11:
                    if (number_day >= 23) {
                        System.out.println("Ваш знак задиака стрелец");
                    } else {
                        System.out.println("Ваш знак задиака скорпион");
                    }
                    break;
                case 12:
                    if (number_day >= 23) {
                        System.out.println("Ваш знак задиака козерог");
                    } else {
                        System.out.println("Ваш знак задиака стрелец");
                    }
                    break;
            }
        } else {
            System.out.println("Вы ввели не верную дату, попробуйте ещё раз");
            task4();
        }
    }

    public static void printArray() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Введите целое положительное число");
        int number = scanner3.nextInt();
        if (number > 0) {
            byte[] massif = new byte[number];
            Random random = new Random();
            random.nextBytes(massif);
            System.out.println(Arrays.toString(massif));
        } else {
            System.out.println("Ошибка: необходимо ввести положительное число. Попробуйте ещё раз");
            printArray();
        }
    }

    public static int operation(int number) {
        if (number > 0) {
            number = number + 1;
        } else if (number < 0) {
            number = number - 2;
        } else if (number == 0) {
            number = 10;
        }
        return number;
    }

    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] % 2 > 0) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void countDevs(int count) {
        if (count % 10 == 1 && !(count % 100 == 11)) {
            System.out.println(count + " программист");
        } else if (count % 10 >= 2 && count % 10 <= 4) {
            if (count % 100 >= 12 && count % 100 <= 14) {
                System.out.println(count + " программистов");
            } else {
                System.out.println(count + " программиста");
            }
        } else {
            System.out.println(count + " программистов");
        }
    }

    public static void foobar(int number) {
        if (number % 3 == 0) {
            System.out.print("foo");
        }
        if (number % 5 == 0) {
            System.out.print("bar");
        }
        System.out.println();
    }

    public static void printPrimeNumbers() {
        int a = 0;
        while (a < 1000) {
            a = a + 1;
            int b = 0;
            int x = 0;
            while (b < 1000) {
                b = b + 1;
                int c = a % b;
                if (c == 0) {
                    x = x + 1;
                }
            }
            if (x <= 2) {
                System.out.println(a);
            }
        }
    }
}