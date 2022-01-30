import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWork {
    public static void main(String[] args) {
        System.out.println(summ(8, 4));
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
    }

    public static int summ(int a, int b) {
        int result = 0;
        for (int i = 1; i <= b; i++) {
            result += a;
        }
        return result;
    }

    public static void task2() {
        String[][] massif = new String[4][4];
        String[][] massif2 = new String[4][4];
        String[][] massif3 = new String[4][4];
        String[][] massif4 = new String[4][4];
        massif[0][0] = " ";
        massif[0][1] = " ";
        massif[0][2] = " ";
        massif[0][3] = "*";
        massif[1][0] = " ";
        massif[1][1] = " ";
        massif[1][2] = "*";
        massif[1][3] = "*";
        massif[2][0] = " ";
        massif[2][1] = "*";
        massif[2][2] = "*";
        massif[2][3] = "*";
        massif[3][0] = "*";
        massif[3][1] = "*";
        massif[3][2] = "*";
        massif[3][3] = "*";
        massif2[0][0] = "*";
        massif2[0][1] = " ";
        massif2[0][2] = " ";
        massif2[0][3] = " ";
        massif2[1][0] = "*";
        massif2[1][1] = "*";
        massif2[1][2] = " ";
        massif2[1][3] = " ";
        massif2[2][0] = "*";
        massif2[2][1] = "*";
        massif2[2][2] = "*";
        massif2[2][3] = " ";
        massif2[3][0] = "*";
        massif2[3][1] = "*";
        massif2[3][2] = "*";
        massif2[3][3] = "*";
        massif3[0][0] = "*";
        massif3[0][1] = "*";
        massif3[0][2] = "*";
        massif3[0][3] = "*";
        massif3[1][0] = " ";
        massif3[1][1] = "*";
        massif3[1][2] = "*";
        massif3[1][3] = "*";
        massif3[2][0] = " ";
        massif3[2][1] = " ";
        massif3[2][2] = "*";
        massif3[2][3] = "*";
        massif3[3][0] = " ";
        massif3[3][1] = " ";
        massif3[3][2] = " ";
        massif3[3][3] = "*";
        massif4[0][0] = "*";
        massif4[0][1] = "*";
        massif4[0][2] = "*";
        massif4[0][3] = "*";
        massif4[1][0] = "*";
        massif4[1][1] = "*";
        massif4[1][2] = "*";
        massif4[1][3] = " ";
        massif4[2][0] = "*";
        massif4[2][1] = "*";
        massif4[2][2] = " ";
        massif4[2][3] = " ";
        massif4[3][0] = "*";
        massif4[3][1] = " ";
        massif4[3][2] = " ";
        massif4[3][3] = " ";
        for (int i = 0; i < massif.length; i++) {
            for (int j = 0; j < massif[i].length; j++) {
                System.out.print(" " + massif[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < massif2.length; i++) {
            for (int j = 0; j < massif2[i].length; j++) {
                System.out.print(" " + massif2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < massif3.length; i++) {
            for (int j = 0; j < massif3[i].length; j++) {
                System.out.print(" " + massif3[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < massif4.length; i++) {
            for (int j = 0; j < massif4[i].length; j++) {
                System.out.print(" " + massif4[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void task3() {
        int x = 0;
        for (int i = 1; i < 100; i += 2) {
            x = x + 1;
        }
        int[] massif = new int[x];
        for (int i = 1, b = 0; i < 100; i += 2, b++) {
            massif[b] = i;
        }
        System.out.println(Arrays.toString(massif));
        for (int i = 0; i < massif.length / 2; i++) {
            int tmp = massif[i];
            massif[i] = massif[massif.length - i - 1];
            massif[massif.length - i - 1] = tmp;
        }
        System.out.println(Arrays.toString(massif));
    }

    public static void task4() {
        int[] mass = new int[12];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            int x = random.nextInt(16);
            mass[i] = x;
        }
        int bol = 0;
        int number = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > bol) {
                bol = mass[i];
                number = i;
            }
        }
        System.out.println(Arrays.toString(mass));
        System.out.println(bol);
        System.out.println(number);
    }

    public static void task5() {
        int[] mass = new int[20];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            int x = random.nextInt(21);
            mass[i] = x;
        }
        System.out.println(Arrays.toString(mass));
        for (int i = 1; i < mass.length; i += 2) {
            mass[i] = 0;
        }
        System.out.println(Arrays.toString(mass));
    }

    public static void task6() {
        int[] mass = new int[]{4, 5, 0, 23, 77, 0, 8, 9, 101, 2};
        int max = 0;
        int x = 0;
        int min = 0;
        int a = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] > max) {
                max = mass[i];
                x = i;
            }
        }
        min = max;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] < min) {
                min = mass[i];
                a = i;
            }
        }
        mass[x] = min;
        mass[a] = max;
        System.out.println(Arrays.toString(mass));
    }

    public static void task7() {
        int[] mass = new int[]{0, 3, 46, 3, 2, 1, 2};
        System.out.print("Массив имеет повторяющиеся элементы ");
        for (int i = 0; i < mass.length; i++) {
            for (int j = i + 1; j < mass.length; j++) {
                if (mass[i] == mass[j]) {
                    System.out.print(mass[j] + " ");
                }
            }
        }
        System.out.println();
    } // Не доконца разобрался, уже сил думать нет. Может завтра попробую еще доразбираться.
    // Либо может вы подскажите. Я немного написал код, но он не совсем правильно работает.
    // Он вычисляет повторяющиеся элементы. Но если повторяющихся элементов 3, то он пишет не то что нужно.

    public static void task8() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число, для размера матрицы");
        int a = scanner.nextInt();
        int[][] b = new int[a][a];
        Random random = new Random();

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                int c = random.nextInt(51);
                b[i][j] = c;
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(" " + b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < b.length; i++) {
            for (int j = i + 1; j < b[i].length; j++) {
                int temp = b[i][j];
                b[i][j] = b[j][i];
                b[j][i] = temp;
            }
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(" " + b[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void task9() {
        int[][] mass = new int[4][4];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                int x = random.nextInt(100);
                mass[i][j] = x;
            }
        }
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                System.out.print(" " + mass[i][j] + " ");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0, j = 0; i < mass.length; i++, j++) {
            sum += mass[i][j];
        }
        System.out.println(sum);
    }

    public static void task10() {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Введите число (количество столбцов)");
        int a = scanner.nextInt();
        System.out.println("Введите число (количество строк)");
        int b = scanner1.nextInt();
        int[][] mass = new int[a][b];
        Random random = new Random();
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                int c = random.nextInt(101);
                mass[i][j] = c;
                if (mass[i][j] % 3 == 0) {
                }
            }
        }
        for (int i = 0; i < mass.length; i++) {
            for (int j = 0; j < mass[i].length; j++) {
                System.out.print(" " + mass[i][j] + " ");
            }
            System.out.println();
        }
    }
}
