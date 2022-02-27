package task5;

public class Main {
    public static void main(String[] args) {
        String word = "code";
        returnTwoCharacters(word);
    }

    public static void returnTwoCharacters(String word) {
        char[] letters = word.toCharArray();
        int char2 = letters.length / 2;
        int char1 = char2 - 1;
        System.out.print(letters[char1]);
        System.out.print(letters[char2]);
    }
}

//5)Даны строки разной длины (длина - четное число), необходимо вернуть ее два средних знака:
//     * Пример: "string" → "ri", "code" → "od", "Practice"→"ct".
