package binary.tree;

public class Populating_Next_Right_Pointers_in_Each_Node_116 {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }

    public class Solution {
        public void connect(TreeLinkNode root) {
            TreeLinkNode cur = root;
            TreeLinkNode head = null, prev = null;

            while (cur != null) {
                while (cur != null) {
                    if (cur.left != null) {
                        if (prev != null) {
                            prev.next = cur.left;
                            prev = prev.next;
                        } else {
                            prev = cur.left;
                            head = cur.left;
                        }
                    }
                    if (cur.right != null) {
                        if (prev != null) {
                            prev.next = cur.right;
                            prev = prev.next;
                        } else {
                            prev = cur.right;
                            head = cur.right;
                        }
                    }
                    cur = cur.next;
                }

                cur = head;
                head = null;
                prev = null;
            }
        }
    }

    public class Solution1 {
        public void connect(TreeLinkNode root) {
            if (root == null || root.left == null)
                return;

            root.left.next = root.right;

            if (root.next != null)
                root.right.next = root.next.left;

            connect(root.left);
            connect(root.right);
        }
    }
}
