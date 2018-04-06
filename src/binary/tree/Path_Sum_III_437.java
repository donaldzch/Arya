package binary.tree;

import java.util.HashMap;
import java.util.Map;

public class Path_Sum_III_437 {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int findPath(TreeNode node, int sum) {
        int result = 0;
        if (node == null)
            return result;
        if (node.val == sum)
            result++;

        result += findPath(node.left, sum - node.val);
        result += findPath(node.right, sum - node.val);
        return result;
    }

    public int pathSum1(TreeNode root, int sum) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        return dfs(root, 0, sum, preSumMap);
    }

    private int dfs(TreeNode node, int currentSum, int target, Map<Integer, Integer> preSumMap) {
        if (node == null)
            return 0;
        currentSum += node.val;

        //See if there is a sub array sum equals to target
        int count = preSumMap.getOrDefault(currentSum - target, 0);

        preSumMap.put(currentSum, preSumMap.getOrDefault(currentSum, 0) + 1);

        count += dfs(node.left, currentSum, target, preSumMap) + dfs(node.right, currentSum, target, preSumMap);

        //Remove the current node so it wont affect other path
        preSumMap.put(currentSum, preSumMap.get(currentSum) - 1);

        return count;
    }
}
