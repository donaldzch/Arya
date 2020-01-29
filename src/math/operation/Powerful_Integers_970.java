package math.operation;

import java.util.*;

class Powerful_Integers_970 {
    class Solution {
        public List<Integer> powerfulIntegers(int x, int y, int bound) {
            Set<Integer> result = new HashSet<>();

            for (int i = 1; i <= bound; i *= x) {
                for (int j = 1; i + j <= bound; j *= y) {
                    result.add(i + j);
                    if (y == 1) {
                        break;
                    }
                }
                if (x == 1) {
                    break;
                }
            }

            return new ArrayList<>(result);
        }
    }
}