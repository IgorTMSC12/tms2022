package task1;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    public static final String INPUT_FILE = "Lesson14/src/main/resources/inputTask1.txt";
    public static final String OUTPUT_FILE = "Lesson14/src/main/resources/outputTask1.txt";

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader(INPUT_FILE);
        FileWriter fileWriter = new FileWriter(OUTPUT_FILE);
        Scanner scanner = new Scanner(fileReader);
        int i = 1;
        while (scanner.hasNextLine()) {
            String a = scanner.nextLine();
            StringBuffer stringBuffer = new StringBuffer(a);
            stringBuffer.reverse();
            if (a.equals(String.valueOf(stringBuffer))) {
                fileWriter.write(a + "\n");
            }
            i++;
        }
        fileWriter.close();
        fileReader.close();
    }
}
//1)В исходном файле hw1/inputTask1.txt находятся слова, каждое слово на новой строке.
//     * После запуска программы должен создать файл outputTask1.txt, который будет содержать в себе только
//       палиндромы.
