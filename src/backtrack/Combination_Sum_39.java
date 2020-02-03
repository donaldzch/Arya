package backtrack;

import java.util.*;

class Combination_Sum_39 {
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            backtrack(result, new ArrayList<>(), candidates, 0, target);
            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> temp, int[] candidates, int start, int remaining) {
            if (remaining < 0) {
                return;
            }
            if (remaining == 0) {
                result.add(new ArrayList<>(temp));
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                temp.add(candidates[i]);
                backtrack(result, temp, candidates, i, remaining - candidates[i]);
                temp.remove(temp.size() - 1);
            }
        }
    }
}