package task4;

public class TextFormatter {

    public void splitSentences(String text) {
        String[] sentences = text.split("\\.");
        for (int i = 0; i < sentences.length; i++) {
            examinationSentences(sentences[i]);
        }
    }

    public void examinationSentences(String sentence) {
        if (polydromeSearch(sentence) || (wordCount(sentence) >= 3 && wordCount(sentence) <= 5)) {
            System.out.println(sentence);
        }
    }

    public static int wordCount(String text) {
        String[] words = text.split(" ");
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            count++;
        }
        return count;
    }

    public static boolean polydromeSearch(String text) {
        String[] words = text.split(" ");
        for (int i = 0; i < words.length; i++) {
            char[] letters = words[i].toCharArray();
            if (letters.length > 1) {
                StringBuffer stringBuffer = new StringBuffer(words[i]);
                if (words[i].equals(String.valueOf(stringBuffer.reverse()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
