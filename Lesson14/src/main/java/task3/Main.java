package task3;

public class Main {
    public static void main(String[] args) {
        TextFormatter textFormatter = new TextFormatter();
        try {
            textFormatter.start();
        } catch (Exception exception) {
            System.out.println("Ошибка");
        }
    }
}

//3) Проверка на цензуру:
//     * Создаете 2 файла.
//     * 1 - й. Содержит исходный текст.
//     * 2 - й. Содержит слова недопустимые в тексте (black list). Структура файла определите сами, хотите
//       каждое слово на новой строке, хотите через запятую разделяйте.
//     * Задача: необходимо проверить проходит ли текст цензуру. Если в тексте не встретилось ни одного
//       недопустимого слова, то выводите сообщение о том что текст прошел проверку на цензуру.
//     * Если нет, то выводите соответствующее сообщение, кол-во предложений не прошедших проверку и сами
//       предложения подлежащие исправлению.
