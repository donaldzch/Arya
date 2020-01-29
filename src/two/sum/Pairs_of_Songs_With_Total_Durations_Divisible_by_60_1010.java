package two.sum;

import java.util.*;

class Pairs_of_Songs_With_Total_Durations_Divisible_by_60 {
    class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            int result = 0;

            Map<Integer, Integer> map = new HashMap<Integer, Integer>();

            for (int t : time) {
                int d = (60 - t % 60) % 60;
                result += map.getOrDefault(d, 0);
                map.put(t % 60, 1 + map.getOrDefault(t % 60, 0));
            }

            return result;
        }
    }
}