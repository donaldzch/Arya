package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_Tree_Level_Order_Traversal_II_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new LinkedList<>();

        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                int level = queue.size();

                List<Integer> levelList = new ArrayList<>();
                for (int i = 0; i < level; i++) {
                    TreeNode treeNode = queue.poll();
                    levelList.add(treeNode.val);
                    if (treeNode.left != null) {
                        queue.offer(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        queue.offer(treeNode.right);
                    }
                }
                result.add(0, levelList);
            }
        }

        return result;
    }
}
