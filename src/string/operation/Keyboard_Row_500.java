package string.operation;

import java.util.ArrayList;

public class Keyboard_Row_500 {

    String[] keyboards = {"QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM"};
    public String[] findWords(String[] words) {
        ArrayList<String> wordList = new ArrayList<>();

        for (String word : words) {
            int row = getRow(word.toUpperCase().charAt(0));

            if (row == -1) {
                continue;
            }
            boolean inRow = true;
            for (char i : word.toUpperCase().toCharArray()) {
                if (keyboards[row].indexOf(i) == -1) {
                    inRow = false;
                    break;
                }
            }
            if (inRow) {
                wordList.add(word);
            }
        }
        return wordList.toArray(new String[wordList.size()]);
    }

    private int getRow(char c) {
        int row = -1;

        for (int i = 0; i < keyboards.length; i++) {
            if (keyboards[i].indexOf(c) != -1) {
                row = i;
                break;
            }
        }

        return row;
    }
}
