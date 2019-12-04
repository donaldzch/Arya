package string.operation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Longest_Word_in_Dictionary_720 {
    class Solution {
        public String longestWord(String[] words) {
            Arrays.sort(words);

            Set<String> allowedWords = new HashSet<>();
            String result = "";

            for (String word : words) {
                if (word.length() == 1 || allowedWords.contains(word.substring(0, word.length() - 1))) {
                    result = result.length() < word.length() ? word : result;
                    allowedWords.add(word);
                }
            }
            return result;
        }
    }
}