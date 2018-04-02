package binary.tree;

import java.util.*;

public class Average_of_Levels_in_Binary_Tree_637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> average = new ArrayList<>();
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.offer(root);

        while (!treeNodes.isEmpty()) {
            double sum = 0.0;
            int size = treeNodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodes.poll();
                sum += treeNode.val;
                if (treeNode.left != null) {
                    treeNodes.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodes.offer(treeNode.right);
                }
            }
            average.add(sum/size);
        }
        return average;
    }
}
