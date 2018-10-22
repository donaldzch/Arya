package binary.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class N_ary_Tree_Postorder_Traversal_590 {

    class Solution {
        public List<Integer> postorder(Node root) {
            List<Integer> ans = new ArrayList<>();
            postorder(root, ans);

            return ans;
        }

        private void postorder(Node root, List<Integer> ans) {
            if (root == null) {
                return;
            }

            for (Node child : root.children) {
                postorder(child, ans);
            }

            ans.add(root.val);
        }
    }

    class Solution1 {
        public List<Integer> postorder(Node root) {
            List<Integer> ans = new LinkedList<>();

            if (root == null)
                return ans;

            Stack<Node> stack = new Stack<>();

            stack.push(root);

            while (!stack.isEmpty()) {
                Node cur = stack.pop();

                if (cur.children != null) {
                    for (int i = 0; i < cur.children.size(); i++) {
                        stack.push(cur.children.get(i));
                    }
                }

                ans.add(0, cur.val);

            }
            return ans;
        }
    }
}
