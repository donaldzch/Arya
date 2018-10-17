package binary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Duplicate_Subtrees_652 {
    class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            List<TreeNode> ans = new ArrayList<>();

            if (root == null) {
                return ans;
            }

            Map<String, Integer> map = new HashMap<>();

            postorder(root, map, ans);

            return ans;
        }


        private String postorder(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
            if (root == null) {
                return "#";
            }

            String sb = root.val + "," + postorder(root.left, map, ans) + "," + postorder(root.right, map, ans);

            map.put(sb, map.getOrDefault(sb, 0) + 1);

            if (map.get(sb) == 2) {
                ans.add(root);
            }

            return sb;
        }

    }
}
