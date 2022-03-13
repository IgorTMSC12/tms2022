package task1;

import java.io.File;

public class Main {
    public static final String DIRECTORY = "lesson14/src/main/resources";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        readFiles(directory);
    }

    public static void readFiles(File directory) {
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                System.out.println(file.getName());
            }
        }
    }
}

//1) Список каталога
//     * Написать метод который циклически просматривает содержимое заданного каталога и выводит на
//       печать информацию о всех файлах и каталогах, находящихся в нем и в его подкаталогах.
//     * Используем рекурсию.
