package string.operation;

import java.util.*;

class Group_Anagrams_49 {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            List<List<String>> result = new ArrayList<>();

            Map<String, List<String>> map = new HashMap<>();

            for(String str : strs) {
                int[] count = new int[26];

                char[] chars = str.toCharArray();

                for (char c : chars) {
                    count[c - 'a']++;
                }

                StringBuilder sb = new StringBuilder("");
                for (int i = 0; i < 26; i++) {
                    sb.append(count[i]).append('#');
                }

                if (!map.containsKey(sb.toString())) {
                    map.put(sb.toString(), new ArrayList<>());
                }
                map.get(sb.toString()).add(str);
            }

            for (List<String> value : map.values()) {
                result.add(value);
            }

            return result;
        }
    }
}