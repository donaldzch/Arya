package string.operation;

import java.util.HashMap;
import java.util.Map;

public class Find_Words_That_Can_Be_Formed_by_Characters_1160 {
    class Solution {
        public int countCharacters(String[] words, String chars) {
            int result = 0;

            Map<Character, Integer> map = new HashMap<>();
            for (char c : chars.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (String word : words) {
                Map<Character, Integer> m = new HashMap<>(map);
                boolean canCount = true;
                for (char c : word.toCharArray()) {
                    if (!m.containsKey(c)) {
                        canCount = false;
                        break;
                    }
                    if (m.get(c) == 0) {
                        canCount = false;
                        break;
                    }
                    m.put(c, m.get(c) - 1);
                }
                if (canCount) {
                    result += word.length();
                }
            }
            return result;
        }
    }
}
