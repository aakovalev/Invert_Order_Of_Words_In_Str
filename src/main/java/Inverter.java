import static java.lang.Character.isSpaceChar;

public class Inverter {
    public void invertOrderOfWords(char[] str) {
        if (isEmpty(str)) {
            return;
        }

        int wordStart = startOfWordIndex(0, str);
        int wordEnd = endOfWordIndex(wordStart, str);

        while (wordStart < str.length - 1) {
            invertOrderOfChars(wordStart, wordEnd, str);
            wordStart = startOfWordIndex(wordEnd + 1, str);
            wordEnd = endOfWordIndex(wordStart, str);
        }

        invertOrderOfChars(0, str.length - 1, str);
    }

    private boolean isEmpty(char[] str) {
        return str.length == 0;
    }

    public String invertOrderOfWords(String str) {
        char[] chars = str.toCharArray();
        invertOrderOfWords(chars);
        return new String(chars);
    }

    public void invertOrderOfChars(int startIndex, int endIndex, char[] str) {
        while (startIndex < endIndex) {
            char temp = str[startIndex];
            str[startIndex] = str[endIndex];
            str[endIndex] = temp;
            startIndex++;
            endIndex--;
        }
    }

    public String invertOrderOfChars(int startIndex, int endIndex, String str) {
        char[] chars = str.toCharArray();
        invertOrderOfChars(startIndex, endIndex, chars);
        return new String(chars) ;
    }

    int startOfWordIndex(int startIndex, char[] str) {
        if (startIndex >= str.length) {
            return str.length - 1;
        }

        int index = startIndex;
        char ch = str[index];

        while (isSpaceChar(ch) && index < str.length - 1) {
            index++;
            ch = str[index];
        }

        return !isSpaceChar(ch) ? index : str.length - 1;
    }

    int endOfWordIndex(int startIndex, char[] str) {
        if (startIndex >= str.length) {
            return str.length - 1;
        }

        int index = startOfWordIndex(startIndex, str);
        char ch = str[index];

        while (!isSpaceChar(ch) && index < str.length - 1) {
            index++;
            ch = str[index];
        }

        return isSpaceChar(ch) ? index - 1 : str.length - 1;
    }
}