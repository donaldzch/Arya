package binary.tree;

import java.util.*;

public class All_Nodes_Distance_K_in_Binary_Tree_863 {
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Map<TreeNode, TreeNode> parentMap = new HashMap<>();

            buildUndirectedGraph(root, null, parentMap);

            return bfs(target, K, parentMap);
        }

        private void buildUndirectedGraph(TreeNode root, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
            if (root == null)
                return;

            parentMap.put(root, parent);
            buildUndirectedGraph(root.left, root, parentMap);
            buildUndirectedGraph(root.right, root, parentMap);
        }

        private List<Integer> bfs(TreeNode target, int K, Map<TreeNode, TreeNode> parentMap) {
            List<Integer> ans = new ArrayList<>();

            Queue<TreeNode> queue = new LinkedList<>();

            Set<TreeNode> visited = new HashSet<>();

            queue.offer(target);
            visited.add(null);

            while (!queue.isEmpty()) {
                int size = queue.size();

                if (K == 0) {
                    for (int i = 0; i < size; i++) {
                        ans.add(queue.poll().val);
                    }
                    return ans;
                }

                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    visited.add(cur);

                    TreeNode parent = parentMap.get(cur);

                    if (!visited.contains(parent)) {
                        queue.offer(parent);
                    }

                    if (!visited.contains(cur.left)) {
                        queue.offer(cur.left);
                    }
                    if (!visited.contains(cur.right)) {
                        queue.offer(cur.right);
                    }
                }

                --K;
            }

            return ans;
        }
    }

    class Solution1 {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                return ans;
            }

            Map<TreeNode, Integer> pathMap = new HashMap<>();

            buildPath(root, target, pathMap);

            dfs(root, target, K, pathMap.get(root), pathMap, ans);

            return ans;
        }

        //calculate the path from root to target which is for two purpose:
        // 1. get any node from root to target if path length great than K
        // 2. if path length is smaller than K, another side of root which is not in the path from root to target
        //    to DFS based on the remaining length "K - PATH_LENGTH"
        private int buildPath(TreeNode root, TreeNode target, Map<TreeNode, Integer> pathMap) {
            if (root == null)
                return -1;
            if (root == target) {
                pathMap.put(root, 0);
                return 0;
            }

            int left = buildPath(root.left, target, pathMap);
            if (left >= 0) {
                pathMap.put(root, left + 1);
                return left + 1;
            }

            int right = buildPath(root.right, target, pathMap);
            if (right >= 0) {
                pathMap.put(root, right + 1);
                return right + 1;
            }
            return -1;
        }

        // get the result based on three situations:
        // 1 and 2 based on buildPath function
        // 3. if target is "root", its subtrees may have a length of K in left or right
        private void dfs(TreeNode root, TreeNode target, int K, int pathLength, Map<TreeNode, Integer> pathMap, List<Integer> ans) {
            if (root == null) {
                return;
            }
            //refresh path length and can cover the subtree not visited
            if (pathMap.containsKey(root)) {
                pathLength = pathMap.get(root);
            }
            if (pathLength == K) {
                ans.add(root.val);
            }

            dfs(root.left, target, K, pathLength + 1, pathMap, ans);

            dfs(root.right, target, K, pathLength + 1, pathMap, ans);
        }
    }
}
