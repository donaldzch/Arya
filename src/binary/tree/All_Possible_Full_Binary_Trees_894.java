package binary.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class All_Possible_Full_Binary_Trees_894 {
    class Solution {
        private Map<Integer, List<TreeNode>> map = new HashMap<>();

        public List<TreeNode> allPossibleFBT(int N) {
            List<TreeNode> list = new ArrayList<>();

            if (N < 1 || N % 2 == 0) {
                return list;
            }

            if (map.containsKey(N)) {
                return map.get(N);
            }

            if (N == 1) {
                list.add(new TreeNode(0));
                return list;
            }

            for (int i = 1; i < N; i += 2) {
                List<TreeNode> leftNodes = allPossibleFBT(i);
                List<TreeNode> rightNodes = allPossibleFBT(N - i - 1);

                for (TreeNode left : leftNodes) {
                    for (TreeNode right : rightNodes) {
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }

            map.put(N, list);

            return list;
        }
    }
}
