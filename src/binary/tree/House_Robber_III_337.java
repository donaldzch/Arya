package binary.tree;

import java.util.HashMap;
import java.util.Map;

public class House_Robber_III_337 {
    class Solution {
        public int rob(TreeNode root) {
            if (root == null)
                return 0;

            int ans = 0;

            if (root.left != null)
                ans += rob(root.left.left) + rob(root.left.right);

            if (root.right != null)
                ans += rob(root.right.left) + rob(root.right.right);

            return Math.max(ans + root.val, rob(root.left) + rob(root.right));
        }
    }

    class Solution1 {
        public int rob(TreeNode root) {
            return dfs(root, new HashMap<>());
        }

        private int dfs(TreeNode root, Map<TreeNode, Integer> map) {
            if (root == null)
                return 0;

            if (map.containsKey(root))
                return map.get(root);

            int ans = 0;

            if (root.left != null)
                ans += rob(root.left.left) + rob(root.left.right);

            if (root.right != null)
                ans += rob(root.right.left) + rob(root.right.right);

            ans = Math.max(ans + root.val, rob(root.left) + rob(root.right));

            map.put(root, ans);

            return ans;
        }
    }

    class Solution2 {
        public int rob(TreeNode root) {
            int[] ans = robHouse(root);
            return Math.max(ans[0], ans[1]);
            //ans[0] denotes that maximum amount when not robbing root
            //ans[1] denotes that maximum amount when robbing root
        }

        private int[] robHouse(TreeNode root) {
            int[] ans = new int[2];

            if (root == null)
                return ans;

            int[] left = robHouse(root.left);
            int[] right = robHouse(root.right);

            ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            ans[1] = root.val + left[0] + right[0];
            return ans;
        }
    }
}
