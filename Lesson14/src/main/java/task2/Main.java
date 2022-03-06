package task2;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static final String INPUT_FIlE = "Lesson14/src/main/resources/inputTask2.txt";
    public static final String OUTPUT_FIlE = "Lesson14/src/main/resources/outputTask2.txt";

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(INPUT_FIlE);
        FileWriter fileWriter = new FileWriter(OUTPUT_FIlE);
        Scanner scanner = new Scanner(fileReader);
        String result = "";
        for (int i = 1; scanner.hasNextLine(); i++) {
            result = result + scanner.nextLine();
        }
        TextFormatter textFormatter = new TextFormatter();
        fileWriter.write(textFormatter.splitSentences(result));
        fileReader.close();
        fileWriter.close();
    }
}

//2)Текстовый файл hw2/inputTask1.txt содержит текст.
//     * После запуска программы в другой файл должны записаться только те предложения, в которых от 3-х до
//       5-ти слов.
//     * Если в предложении присутствует слово-палиндром, то не имеет значения какое кол-во слов в предложении,
//       оно попадает в outputTask1.txt файл.
//     * Пишем все в ООП стиле. Создаем класс TextFormatter
//     * в котором два метода:
//     * 1. Метод принимает строку и возвращает кол-во слов в строке.
//     * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true,
//       если нет false
//     * В main считываем файл.
//     * Разбиваем текст на предложения. Используя методы класса TextFormatter определяем подходит ли нам
//       предложение.
//     * Если подходит добавляем его в outputTask1.txt файл
