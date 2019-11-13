package string.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Find_Common_Characters_1002 {
    class Solution {
        public List<String> commonChars(String[] A) {
            Map<Character, Integer> intersect = new HashMap<>();

            for (char c : A[0].toCharArray()) {
                intersect.put(c, intersect.getOrDefault(c, 0) + 1);
            }

            for (int i = 1; i < A.length; i++) {
                Map<Character, Integer> map = new HashMap<>();
                for (char c : A[i].toCharArray()) {
                    map.put(c, map.getOrDefault(c, 0) + 1);
                }

                for (Map.Entry<Character, Integer> entry : intersect.entrySet()) {
                    if (map.containsKey(entry.getKey())) {
                        intersect.put(entry.getKey(), Math.min(entry.getValue(), map.get(entry.getKey())));
                    } else {
                        intersect.put(entry.getKey(), 0);
                    }
                }
            }

            List<String> result = new ArrayList<>();

            for (Map.Entry<Character, Integer> entry : intersect.entrySet()) {
                for (int i = 0; i < entry.getValue(); i++) {
                    result.add(String.valueOf(entry.getKey()));
                }
            }
            return result;
        }


    }
}