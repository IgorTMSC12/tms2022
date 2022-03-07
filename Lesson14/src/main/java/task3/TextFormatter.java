package task3;

import java.io.FileReader;
import java.util.Scanner;

public class TextFormatter {
    public static final String TEXT = "Lesson14/src/main/resources/textTask3.txt";
    public static final String BLACKLIST = "Lesson14/src/main/resources/balckListTask3.txt";
    int count = 0;

    public void start() throws Exception {
        String word = readTextFile(TEXT);
        textCheck(word);
    }

    private String readTextFile(String text) throws Exception {
        FileReader fileReader = new FileReader(text);
        Scanner scanner = new Scanner(fileReader);
        String result = "";
        while (scanner.hasNextLine()) {
            result = result + scanner.nextLine();
        }
        scanner.close();
        fileReader.close();
        return result;
    }

    public void textCheck(String text) throws Exception {
        String[] sentence = text.split("[.!?]");
        for (int i = 0; i < sentence.length; i++) {
            String[] word = sentence[i].split(" ");
            String result = readTextFile(BLACKLIST);
            String[] wordBlackList = result.split(" ");
            for (int k = 0; k < wordBlackList.length; k++) {
                for (int j = 0; j < word.length; j++) {
                    if (wordBlackList[k].equalsIgnoreCase(word[j])) {
                        System.out.println("Предложение подлежащее к исправлению:");
                        System.out.println(sentence[i]);
                        count++;

                    }
                }
            }
        }
        if (count == 0) {
            System.out.println("Текст прошёл проверку");
        } else {
            System.out.println("Количество предложений не прошедших проверку " + count);
        }
    }
}
