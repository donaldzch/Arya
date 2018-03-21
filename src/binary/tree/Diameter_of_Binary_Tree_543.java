package binary.tree;

public class Diameter_of_Binary_Tree_543 {


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int[] result = new int[1];
        degreeOfTree(root, result);
        return result[0];
    }

    private int degreeOfTree(TreeNode node, int[] result) {
        if (node == null)
            return 0;
        int leftDegree = degreeOfTree(node.left, result);
        int rightDegree = degreeOfTree(node.right, result);
        result[0] = Math.max(result[0], leftDegree + rightDegree);
        return Math.max(leftDegree, rightDegree) + 1;
    }

}
