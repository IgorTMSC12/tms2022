public class HomeWork {
    public static void main(String[] args) {
        printLiterals();
        System.out.println(sum(100, 200));
        System.out.println(sum(Integer.MAX_VALUE, Integer.MAX_VALUE));
        System.out.println(max(56, 349));
        System.out.println(max1());
        System.out.println(max2());
        System.out.println(calculateHypotenuse(3, 4));
        System.out.println(calculateHypotenuse1());
    }

    private static void printLiterals() {
        boolean a = false;
        System.out.println("Литерал логического вида: " + a); //литерал логического вида

        String b = "Hello";
        System.out.println("Литерал строкового вид: " + b); //литерал строкового вида

        char c = 'a';
        System.out.println("Литерал символьного вида: " + c); //литерал символьного вида

        int d = 0b1101;
        System.out.println("Литерал 2-й системы счисления: " + d); // литерал двоичного вида исчесления

        int e = 010;
        System.out.println("Литерал 8-й системы счисления: " + e); //литерал восьмиричного система исчесления

        int f = 15;
        System.out.println("Литерал 10-й системы счисления: " + f); //литерал десятирочной системы исчесления

        int g = 0x10;
        System.out.println("Литерал 16-й системы счисления: " + g); //литерал 16-ой системы исчесления

        float q = 7.48f;
        System.out.println("Литерал типа float: " + q); // литерал типа float

        double w = 15.75;
        System.out.println("Литерал типа double: " + w); //литерал типа double
    }

    public static long sum(int a, int b) {
        long c = (long) a + (long) b;
        if (c > Integer.MAX_VALUE) {
            return -1;
        } else {
            return c;
        }
    }

    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max1() {
        int a = 4;
        int b = 5;
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    public static int max2() {
        int a = 10;
        int b = 10;
        if (a >= b) {
            return a;
        } else {
            return b;
        }
    }

    public static int calculateHypotenuse(int a, int b) {
        int step = 2;
        int a1 = (int) Math.sqrt(Math.pow(a, step) + Math.pow(b, step));
        return a1;
    }

    public static int calculateHypotenuse1() {
        int a = 12;
        int b = 16;
        int step = 2;
        int a1 = (int) Math.sqrt(Math.pow(a, step) + Math.pow(b, step));
        return a1;
    }
}
