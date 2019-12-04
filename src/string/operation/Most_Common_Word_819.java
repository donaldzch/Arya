package string.operation;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

class Most_Common_Word_819 {
    class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

            String[] parts = paragraph.replaceAll("\\W+", "").toLowerCase().split("\\s+");

            Map<String, Integer> map = new HashMap<>();

            for (String part : parts) {
                map.put(part, map.getOrDefault(part, 0) + 1);
            }

            String result = null;

            Integer mostCommon = 0;

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (!bannedSet.contains(entry.getKey())) {
                    if (mostCommon < entry.getValue()) {
                        mostCommon = entry.getValue();
                        result = entry.getKey();
                    }
                }
            }

            return result;
        }
    }
}