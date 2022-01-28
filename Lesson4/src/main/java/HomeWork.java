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
        int ameba = 0;
        while (ameba <= 24) {
            if (ameba == 3) {
                System.out.println("Через 3 часа одноклеточная амёба разделилась на 2 одноклеточные амёбы");
            }
            if (ameba == 6) {
                System.out.println("Через 6 часов 2-е одноклеточные амёбы разделились на 4 одноклеточных амёб");
            }
            if (ameba == 9) {
                System.out.println("Через 9 часов 4 одноклеточные амёбы разделились на 8 одноклеточных амёб");
            }
            if (ameba == 12) {
                System.out.println("Через 12 часов 8 одноклеточных амёб разделились на 16 одноклеточных амёб");
            }
            if (ameba == 15) {
                System.out.println("Через 15 часов 16 одноклеточных амёб разделились на 32 одноклеточных амёб");
            }
            if (ameba == 18) {
                System.out.println("Через 18 часов 32 одноклеточные амёбы разделились на 64 одноклеточных амёб");
            }
            if (ameba == 21) {
                System.out.println("Через 21 час 64 одноклеточные амёбы разделились на 128 одноклеточных амёб");
            }
            if (ameba == 24) {
                System.out.println("Через 24 часа 128 одноклеточных амёб разделились на 256 одноклеточных амёб");
            }
            ameba = ameba + 3;
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
    } // Найти колличество цифр.

    public static void task4() {
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Введите число Вашего дня рождения");
        int number_day = scanner2.nextInt();
        System.out.println("Введите число Вашего месяца вашего дня рождения");
        int number_moth = scanner3.nextInt();
        if (number_day <= 31 && number_moth <= 12) {
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
    // Ещё можно написать условие на то, что если пользователь введёт десятичное число.

    public static void printArray() {
        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Введите целое положительное число");
        int number = scanner3.nextInt();
        if (number < 0) {
            System.out.println("Ошибка: необходимо ввести положительное число. Попробуйте ещё раз");
            printArray();
        } else {
            byte[] massif = new byte[number];
            Random random = new Random();
            random.nextBytes(massif);
            System.out.println(Arrays.toString(massif));
        }
    }

    public static int operation(int number) {
        if (number > 0) {
            number = number + 1;
            return number;
        } else if (number < 0) {
            number = number - 2;
            return number;
        } else if (number == 0) {
            number = 10;
            return number;
        }
        return 0;
    }

    public static int calculateCountOfOddElementsInMatrix(int[] ints) {
        int count = 0;
        int i;
        for (i = 0; i < ints.length; i++) {
            if (ints[i] % 2 > 0) {
                count = count + 1;
            }
        }
        return count;
    }

    public static void countDevs(int count) {
        if (count % 10 == 1 && !(count % 100 == 11)) {
            System.out.println(count + " программист");
        } else if (count % 10 == 2 || count % 10 == 3 || count % 10 == 4) {
            if (count % 100 == 12 || count % 100 == 13 || count % 100 == 14) {
                System.out.println(count + " программистов");
            }
            System.out.println(count + " программиста");
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
        int number;
        for (number = 0; number <= 1000; number++) {
            if (!(number % 2 == 0 || number % 3 == 0 || number % 5 == 0)) {
                System.out.println(number);
            } else if (number == 2 || number == 3 || number == 5) {
                System.out.println(number);
            }
        }
    }
}
