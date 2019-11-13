package binary.tree;

public class Construct_Binary_Search_Tree_from_Preorder_Traversal_1008 {
    class Solution {
        public TreeNode bstFromPreorder(int[] preorder) {
            return dfs(preorder, 0, preorder.length);
        }

        private TreeNode dfs(int[] preorder, int start, int end) {
            if (start >= end) {
                return null;
            }
            int value = preorder[start];
            TreeNode root = new TreeNode(preorder[start]);

            int split;
            for (split = start + 1; split < end; split++) {
                if (preorder[split] > value) {
                    break;
                }
            }
            root.left = dfs(preorder, start + 1, split);
            root.right = dfs(preorder, split, end);

            return root;
        }
    }
}
