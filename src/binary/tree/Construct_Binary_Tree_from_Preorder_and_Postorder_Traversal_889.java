package binary.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal_889 {
    class Solution {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            Map<Integer, Integer> posMap = new HashMap<>();

            for (int i = 0; i < post.length; i++) {
                posMap.put(post[i], i + 1);
            }

            return construct(pre, 0, pre.length - 1,
                    post, 0, pre.length - 1,
                    posMap);
        }

        private TreeNode construct(int[] pre, int preStart, int preEnd,
                                   int[] post, int postStart, int postEnd,
                                   Map<Integer, Integer> postMap) {
            if (preStart > preEnd || postStart > postEnd) {
                return null;
            }

            TreeNode node = new TreeNode(pre[preStart]);

            if (preStart + 1 <= preEnd) {

                int pos = postMap.get(pre[preStart + 1]) - postStart;

                node.left = construct(pre, preStart + 1, preStart + 1 + pos, post, postStart, postStart + pos, postMap);
                node.right = construct(pre, preStart + 1 + pos + 1, preEnd, post, postStart + pos + 1, postEnd - 1, postMap);
            }

            return node;
        }
    }

    class Solution1 {
        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            Stack<TreeNode> stack = new Stack<>();

            stack.push(new TreeNode(pre[0]));

            for (int i = 1, j = 0; i < pre.length; i++) {
                TreeNode node = new TreeNode(pre[i]);

                while (stack.peek().val == post[j]) {
                    stack.pop();
                    j++;
                }

                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }

                stack.push(node);
            }

            return stack.firstElement();
        }
    }
}
