package binary.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Distance_Between_BST_Nodes_783 {

    public int minDiffInBST(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Integer[] previous = new Integer[1];
        min = inorderMinDiff(root, previous, min);
        return min;
    }

    private int inorderMinDiff(TreeNode current, Integer[] previous, int min) {
        if (current == null)
            return min;
        min = inorderMinDiff(current.left, previous, min);
        if (previous[0] != null)
            min = Math.min(min, Math.abs(current.val - previous[0]));
        previous[0] = current.val;
        return inorderMinDiff(current.right, previous, min);
    }

    public static TreeNode stringToTreeNode(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return null;
        }

        String[] parts = input.split(",");
        String item = parts[0];
        TreeNode root = new TreeNode(Integer.parseInt(item));
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        int index = 1;
        while(!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.remove();

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int leftNumber = Integer.parseInt(item);
                node.left = new TreeNode(leftNumber);
                nodeQueue.add(node.left);
            }

            if (index == parts.length) {
                break;
            }

            item = parts[index++];
            item = item.trim();
            if (!item.equals("null")) {
                int rightNumber = Integer.parseInt(item);
                node.right = new TreeNode(rightNumber);
                nodeQueue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            TreeNode root = stringToTreeNode(line);

            int ret = new Minimum_Distance_Between_BST_Nodes_783().minDiffInBST(root);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
