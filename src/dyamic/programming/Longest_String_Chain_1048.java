package dyamic.programming;

import java.util.*;

class Longest_String_Chain_1048 {
    class Solution {
        public int longestStrChain(String[] words) {
            Arrays.sort(words, (a, b) -> a.length() - b.length());
            Map<String, Integer> dp = new HashMap<>();
            int result = 0;
            for (String word : words) {
                int longest = 0;
                for (int i = 0; i < word.length(); i++) {
                    String prev = word.substring(0, i) + word.substring(i + 1);
                    longest = Math.max(longest, dp.getOrDefault(prev, 0) + 1);
                }
                dp.put(word, longest);
                result = Math.max(result, longest);
            }
            return result;
        }
    }
}