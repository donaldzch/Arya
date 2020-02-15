package greedy;

import java.util.*;

class Maximum_Length_of_Pair_Chain_646 {
    class Solution {
        public int findLongestChain(int[][] pairs) {
            Arrays.sort(pairs, (a, b) -> a[1] - b[1]);
            
            int result = 0;
            int current = Integer.MIN_VALUE;
            for (int i = 0; i < pairs.length; i++) {
                if (current < pairs[i][0]) {
                    current = pairs[i][1];
                    result++;
                }
            }
            return result;
        }
    }
}