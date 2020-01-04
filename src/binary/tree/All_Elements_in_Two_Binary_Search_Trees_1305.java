package binary.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class All_Elements_in_Two_Binary_Search_Trees_1305 {
    class Solution {
        public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
            Deque<TreeNode> s1 = new ArrayDeque<>();
            Deque<TreeNode> s2 = new ArrayDeque<>();

            TreeNode cur1 = root1;
            TreeNode cur2 = root2;

            List<Integer> result = new ArrayList<>();

            do {
                while (cur1 != null) {
                    s1.push(cur1);
                    cur1 = cur1.left;
                }
                while (cur2 != null) {
                    s2.push(cur2);
                    cur2 = cur2.left;
                }
                if (!s1.isEmpty() && !s2.isEmpty()) {
                    if (s1.peek().val < s2.peek().val) {
                        cur1 = s1.pop();
                        result.add(cur1.val);
                        cur1 = cur1.right;
                    } else {
                        cur2 = s2.pop();
                        result.add(cur2.val);
                        cur2 = cur2.right;
                    }
                } else {
                    if (!s1.isEmpty()) {
                        cur1 = s1.pop();
                        result.add(cur1.val);
                        cur1 = cur1.right;
                    }
                    if (!s2.isEmpty()) {
                        cur2 = s2.pop();
                        result.add(cur2.val);
                        cur2 = cur2.right;
                    }
                }


            } while (!s1.isEmpty() || !s2.isEmpty() || cur1 != null || cur2 != null);

            return result;
        }
    }
}