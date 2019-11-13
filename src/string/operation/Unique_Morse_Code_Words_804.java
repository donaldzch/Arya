package string.operation;

import java.util.HashSet;
import java.util.Set;

public class Unique_Morse_Code_Words_804 {
    class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] MORSE = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                    "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                    "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

            Set<String> result = new HashSet<>();

            for (String word : words) {
                StringBuilder sb = new StringBuilder();
                for (char c : word.toCharArray()) {
                    sb.append(MORSE[c - 'a']);
                }
                result.add(sb.toString());
            }

            return result.size();
        }
    }
}
