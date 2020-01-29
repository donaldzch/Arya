package math.operation;

import java.util.*;

class X_of_a_Kind_in_a_Deck_of_Cards_914 {
    class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            Map<Integer, Integer> count = new HashMap<>();

            for (int num : deck) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }

            int result = 0;
            for (int i : count.values()) {
                result = gcd(i, result);
            }
            return result > 1;
        }

        public int gcd(int a, int b) {
            return b > 0 ? gcd(b, a % b) : a;
        }
    }
}