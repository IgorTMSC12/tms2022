package task2;

public class TextFormatter {

    public String splitSentences(String text) {
        String[] sentences = text.split("[.!?]");
        String result = "";
        for (int i = 0; i < sentences.length; i++) {
            result = result + examinationSentences(sentences[i]);
        }
        return result;
    }

    private String examinationSentences(String sentence) {
        if (examinationPalindrome(sentence) || (wordCount(sentence) >= 3 && wordCount(sentence) <= 5)) {
            return sentence + "\n";
        }
        return "";
    }

    private int wordCount(String text) {
        String[] texts = text.split(" ");
        return texts.length;
    }

    private boolean examinationPalindrome(String text) {
        String[] texts = text.split(" ");
        for (int i = 0; i < texts.length; i++) {
            char[] letters = texts[i].toCharArray();
            if (letters.length > 1) {
                StringBuffer stringBuffer = new StringBuffer(texts[i]);
                if (texts[i].equalsIgnoreCase(String.valueOf(stringBuffer.reverse()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
