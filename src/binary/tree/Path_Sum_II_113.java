package binary.tree;

import java.util.ArrayList;
import java.util.List;

public class Path_Sum_II_113 {
    class Solution {
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            pathSum(root, sum, ans, list);
            return ans;
        }

        private void pathSum(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> list) {
            if (root == null)
                return;

            list.add(root.val);

            if (root.left == null && root.right == null && sum == root.val) {
                ans.add(new ArrayList<>(list));
                list.remove(list.size() - 1);
                return;
            }

            pathSum(root.left, sum - root.val, ans, list);
            pathSum(root.right, sum - root.val, ans, list);
            list.remove(list.size() - 1);

            return;
        }
    }
}
