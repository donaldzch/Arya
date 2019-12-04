package string.operation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Groups_of_Special_Equivalent_Strings_893 {
    class Solution {
        public int numSpecialEquivGroups(String[] A) {
            Set<String> result = new HashSet<>();

            for (String a : A) {
                int[] even = new int[26], odd = new int[26];

                for (int i = 0; i < a.length(); i++) {
                    if (i % 2 == 0) {
                        even[a.charAt(i) - 'a']++;
                    } else {
                        odd[a.charAt(i) - 'a']++;
                    }
                }
                result.add(Arrays.toString(even) + Arrays.toString(odd));
            }

            return result.size();
        }
    }
}