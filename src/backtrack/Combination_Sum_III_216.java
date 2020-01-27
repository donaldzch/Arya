package backtrack;

import java.util.*;

class Combination_Sum_III_216 {
    class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            backtrack(result, new ArrayList<>(), k, 1, n);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> temp, int k, int start, int target) {
            if (temp.size() > k) {
                return;
            }

            if (temp.size() == k && target == 0) {
                result.add(new ArrayList<>(temp));
                return;
            }

            for (int i = start; i <= 9; i++) {
                if (target - i >= 0) {
                    temp.add(i);
                    backtrack(result, temp, k, i + 1, target - i);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }
}