package string.operation;

import java.util.*;

class Camelcase_Matching_1023 {
    class Solution {
        public List<Boolean> camelMatch(String[] queries, String pattern) {
            List<Boolean> result = new ArrayList<>();

            for (int i = 0; i < queries.length; i++) {
                boolean isMatch = match(queries[i], pattern);
                result.add(isMatch);
            }
            return result;
        }

        private boolean match(String query, String pattern) {
            int j = 0;
            for (int i = 0; i < query.length(); i++) {
                if (j < pattern.length() && query.charAt(i) == pattern.charAt(j)) {
                    j++; 
                } else {
                    if (Character.isUpperCase(query.charAt(i))) {
                        return false;
                    }
                }
            }

            return j == pattern.length();
        }
    }
}