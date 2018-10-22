package binary.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class N_ary_Tree_Preorder_Traversal_589 {
    class Solution {
        public List<Integer> preorder(Node root) {
            List<Integer> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Stack<Node> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {
                Node cur = stack.pop();

                if (cur.children != null) {
                    for (int i = cur.children.size() - 1; i >= 0; i--) {
                        stack.push(cur.children.get(i));
                    }
                }

                ans.add(cur.val);
            }

            return ans;
        }
    }

    class Solution1 {
        public List<Integer> preorder(Node root) {
            List<Integer> ans = new ArrayList<>();

            preorder(root, ans);

            return ans;
        }

        private void preorder(Node root, List<Integer> ans) {
            if (root == null)
                return;

            ans.add(root.val);

            if (root.children != null) {
                for (Node child : root.children) {
                    preorder(child, ans);
                }
            }
        }
    }
}
