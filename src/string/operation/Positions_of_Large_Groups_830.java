package string.operation;

import java.util.*;

class Positions_of_Large_Groups_830 {
    class Solution {
        public List<List<Integer>> largeGroupPositions(String S) {
            char[] chars = S.toCharArray();

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0, j = 0; i < chars.length; i = j) {
                while (j < chars.length && chars[i] == chars[j]) {
                    j++;
                }
                if (j - i >= 3) {
                    result.add(Arrays.asList(i, j - 1));
                }
            }
            return result;
        }
    }
}