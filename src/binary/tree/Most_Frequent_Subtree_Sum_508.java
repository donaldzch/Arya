package binary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Most_Frequent_Subtree_Sum_508 {
    class Solution {
        private int maxCount;

        public int[] findFrequentTreeSum(TreeNode root) {
            Map<Integer, Integer> map = new HashMap<>();
            maxCount = 0;

            postorder(root, map);

            List<Integer> result = new ArrayList<>();

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount)
                    result.add(entry.getKey());
            }

            int[] ans = new int[result.size()];

            for (int i = 0; i < ans.length; i++) {
                ans[i] = result.get(i);
            }

            return ans;
        }

        private int postorder(TreeNode root, Map<Integer, Integer> map) {
            if (root == null)
                return 0;

            int left = postorder(root.left, map);
            int right = postorder(root.right, map);

            int sum = left + right + root.val;

            int count = map.getOrDefault(sum, 0);

            count++;

            maxCount = Math.max(count, maxCount);

            map.put(sum, count);

            return sum;
        }
    }


}
