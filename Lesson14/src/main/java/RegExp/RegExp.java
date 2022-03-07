package RegExp;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    //1) Даны строки разной длины c четным числом символов(казаки, просмотреть и так далее),
    //     *  необходимо вернуть ее два средних знака.
    //     * Например, если дана строка "string"  результат будет "ri", для строки "code" результат "od",
    //       для "Practice" результат "ct".
    public static void task1() {
        String text = "казаки";
        String result = text.substring(text.length() / 2 - 1, text.length() / 2 + 1);
        System.out.println(result);
    }

    //2) Дана строка "cab, ccab, cccab" Необходимо составить регулярное выражение, сделать класс Pattern,
    //   Matcher, вызвать метод find и вывести слова на консоль
    //     * Должно вывести:
    //     * cab
    //     * ccab
    //     * cccab
    public static void task2() {
        String text = "cab, ccab, cccab";
        Pattern pattern = Pattern.compile("c+.b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    //3) Дана строка "Versions: Java  5, Java 6, Java   7, Java 8, Java 12."  Найти все подстроки "Java X",
    //   где X - число и распечатать их.
    public static void task3() {
        String text = "Versions: Java  5, Java 6, Java   7, Java 8, Java 12.";
        Pattern pattern = Pattern.compile("Java\\s+\\d+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    //4*)со звездочкой! Предложение состоит из нескольких слов, разделенных пробелами. Например: "One two
    //   three раз два три one1 two2 123 ".
    //     *  Найти количество слов, содержащих только символы латинского алфавита.
    //     *  Необходимо составить регулярное выражение и вызвать его в методе split(Regexp)
    //     *  String str = "One two three раз два три one1 two2 123 ";
    //     *  System.out.println(str.split("регулярное выражение").length);
    //     *  Подсказка: тут надо использовать:
    //     *  1) группы ()
    //     *  2) | - оператор или
    //     *  3) [] - группировки символов
    //     *  4) +,* - квантификаторы
    public static void task4() {
        String str = "One two three раз два три one1 two2 123 ";
        System.out.println(str.split("[a-zA-Z]+").length);
    }
    //Что то не совсем понял про вашу подсказку, что нужно использовать все эти символы. Но и решение что то
    //не то у меня

    //5*)со звездочкой! В метод на вход приходит строка
    //     *
    //     *  public static boolean validate(String str) {
    //            return false;
    //        }
    //     * Необходимо выполнить проверку на валидацию входящей строки и вернуть false или true
    //     * - Строка должна содержать только маленькие латинские буквы и цифры 1 или 5 без знака подчеркивания.
    //     * - Длина строки должна быть от 4 до 20 символов.
    public static void task5() {
        String text = "password15";
        System.out.println(validate(text));
    }

    public static boolean validate(String str) {
        return str.matches("[a-z15]{4,20}");
    }
}
