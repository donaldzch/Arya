package binary.tree;

public class Maximum_Depth_of_N_ary_Tree_559 {
    class Solution {
        public int maxDepth(Node root) {
            if (root == null)
                return 0;

            int depth = 0;
            if (root.children != null) {
                for (Node child : root.children) {
                    depth = Math.max(depth, maxDepth(child));
                }
            }

            return depth + 1;
        }
    }
}
