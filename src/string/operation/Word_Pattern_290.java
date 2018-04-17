package string.operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Word_Pattern_290 {
    public boolean wordPattern(String pattern, String str) {
        String[] tokens = str.split(" ");

        if (pattern.length() != tokens.length) {
            return false;
        }

        Map<Character, Integer> charMap = new HashMap<>();
        Map<String, Integer> strMap = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(charMap.put(pattern.charAt(i), i), strMap.put(tokens[i], i))) {
                return false;
            }
        }
        return true;
    }
}
