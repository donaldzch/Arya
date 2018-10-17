package binary.tree;

public class Kth_Smallest_Element_in_a_BST_230 {
    class Solution {

        public int kthSmallest(TreeNode root, int k) {
            int[] result = new int[2];
            result[0] = k;
            kthSmallest(root, result);
            return result[1];
        }

        private void kthSmallest(TreeNode root, int[] result) {
            if (root == null)
                return;
            kthSmallest(root.left, result);

            if (--result[0] == 0)
                result[1] = root.val;

            kthSmallest(root.right, result);
        }
    }

    class Solution1 {
        public int kthSmallest(TreeNode root, int k) {
            int left = nodeCount(root.left);  // this value can be saved in the root node
            if (left + 1 == k) {
                return root.val;
            } else if (left + 1 < k) {
                return kthSmallest(root.right, k - left - 1);
            } else {
                return kthSmallest(root.left, k);
            }
        }

        private int nodeCount(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + nodeCount(root.left) + nodeCount(root.right);
        }
    }
}
