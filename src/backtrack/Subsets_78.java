package backtrack;

import java.util.ArrayList;
import java.util.List;

class Subsets_78 {
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            backtrack(result, new ArrayList<Integer>(), nums, 0);

            return result;
        }

        private void backtrack(List<List<Integer>> result, List<Integer> cur, int[] nums, int start) {
            result.add(new ArrayList<>(cur));

            for (int i = start; i < nums.length; i++) {
                cur.add(nums[i]);
                backtrack(result, cur, nums, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
}