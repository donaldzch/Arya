package string.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Uncommon_Words_from_Two_Sentences_884 {
    class Solution {
        public String[] uncommonFromSentences(String A, String B) {
            Map<String, Integer> map = new HashMap<>();

            List<String> result = new ArrayList<>();

            for (String a : A.split("\\s+")) {
                map.put(a, map.getOrDefault(a, 0) + 1);
            }

            for (String b : B.split("\\s+")) {
                map.put(b, map.getOrDefault(b, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    result.add(entry.getKey());
                }
            }

            return result.toArray(new String[result.size()]);
        }
    }

}