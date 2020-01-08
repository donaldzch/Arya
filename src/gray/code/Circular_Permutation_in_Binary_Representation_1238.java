package gray.code;

import java.util.ArrayList;

public class Circular_Permutation_in_Binary_Representation_1238 {
    class Solution {
        public List<Integer> circularPermutation(int n, int start) {
            //grey code
            //00 01 11 10
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < (1 << n); i++) {
                result.add(start ^ i ^ i >> 1);
            }
            return result;
        }
    }
}