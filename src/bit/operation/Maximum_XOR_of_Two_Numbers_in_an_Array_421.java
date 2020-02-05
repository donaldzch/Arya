package bit.operation;

import java.util.*;

class Maximum_XOR_of_Two_Numbers_in_an_Array_421 {
    class Solution {
        public int findMaximumXOR(int[] nums) {
            int result = 0;
            int mask = 0;

            for (int i = 31; i >= 0; i--) {
                mask |= 1 << i;

                Set<Integer> set = new HashSet<>();

                for (int num : nums) {
                    set.add(num & mask);
                }

                int temp = result | (1 << i);
                for (int prefix : set) {
                    if (set.contains(temp ^ prefix)){
                        result = temp;
                        break;
                    }
                }
            }
            return result;
        }
    }
}