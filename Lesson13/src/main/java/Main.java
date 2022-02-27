public class Main {

    public static void main(String[] args) {
        task1();
        task2();
        task3();
    }

    //1) Вырезать подстроку из строки начиная с первого вхождения символа(А) до, последнего вхождения сивола(B).
    public static void task1() {
        String stringTask1 = "CADBWT";
        int firstIndex = stringTask1.indexOf('A');
        int lastIndex = stringTask1.lastIndexOf('B');
        String result = stringTask1.substring(firstIndex, lastIndex + 1);
        System.out.println(result);
    }

    //2) Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в позиции 0
    public static void task2() {
        String stringTask2 = "AFSDGDG";
        char a = stringTask2.charAt(3);
        char b = stringTask2.charAt(0);
        String p = stringTask2.replace(a, b);
        System.out.println(p);
    }

    //3) В массиве находятся слова. Вывести на экран слова палиндромы
    public static void task3() {
        String[] words = new String[]{"дед", "казак", "дед", "телефон"};
        for (int i = 0; i < words.length; i++) {
            StringBuffer stringBuffer = new StringBuffer(words[i]);
            if (words[i].equals(String.valueOf(stringBuffer.reverse()))) {
                System.out.println(words[i]);
            }
        }
    }
}
