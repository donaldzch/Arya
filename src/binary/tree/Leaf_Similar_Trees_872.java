package binary.tree;

import java.util.ArrayList;
import java.util.List;

public class Leaf_Similar_Trees_872 {
    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> ans1 = new ArrayList<>();
            List<Integer> ans2 = new ArrayList<>();

            preorder(root1, ans1);
            preorder(root2, ans2);

            return ans1.equals(ans2);
        }

        private void preorder(TreeNode root, List<Integer> ans) {
            if (root == null)
                return;

            if (root.left == null && root.right == null)
                ans.add(root.val);

            preorder(root.left, ans);
            preorder(root.right, ans);
        }
    }
}
