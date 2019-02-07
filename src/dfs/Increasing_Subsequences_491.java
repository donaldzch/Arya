package dfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Increasing_Subsequences_491 {
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(nums, 0, ans, new ArrayList<>());
            return ans;
        }

        private void dfs(int[] nums, int index, List<List<Integer>> ans, List<Integer> current) {
            if (current.size() > 1) {
                ans.add(new ArrayList<>(current));
            }
            Set<Integer> duplicate = new HashSet<>();
            for (int j = index; j < nums.length; j++) {
                if (duplicate.contains(nums[j])) {
                    continue;
                }
                if (current.size() == 0 || nums[j] >= current.get(current.size() - 1)) {
                    duplicate.add(nums[j]);
                    current.add(nums[j]);
                    dfs(nums, j + 1, ans, current);
                    current.remove(current.size() - 1);
                }
            }
        }
    }
}
