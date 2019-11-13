package string.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_and_Replace_Pattern_890 {
    class Solution {
        public List<String> findAndReplacePattern(String[] words, String pattern) {
            List<String> result = new ArrayList<>();
            for (String word : words) {
                if (match(word, pattern)) {
                    result.add(word);
                }
            }
            return result;
        }

        private boolean match(String word, String pattern) {
            Map<Character, Character> map = new HashMap<>();

            for (int i = 0; i < word.length(); i++) {
                char w = word.charAt(i);
                char p = pattern.charAt(i);

                if (!map.containsKey(w)) {
                    map.put(w, p);
                }
                if (map.get(w) != p) {
                    return false;
                }
            }

            boolean[] visited = new boolean[26];

            for (char p : map.values()) {
                if (visited[p - 'a']) {
                    return false;
                }
                visited[p - 'a'] = true;
            }
            return true;
        }
    }
}
