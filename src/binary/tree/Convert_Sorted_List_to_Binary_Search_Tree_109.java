package binary.tree;

import linked.list.ListNode;

public class Convert_Sorted_List_to_Binary_Search_Tree_109 {
    class Solution {
        public TreeNode sortedListToBST(ListNode head) {
            return dfs(head, null);
        }

        private TreeNode dfs(ListNode start, ListNode end) {
            ListNode mid = getMidNode(start, end);

            if (mid == null)
                return null;

            TreeNode root = new TreeNode(mid.val);
            root.left = dfs(start, mid);
            root.right = dfs(mid.next, end);

            return root;
        }

        private ListNode getMidNode(ListNode start, ListNode end) {
            ListNode fast = start, slow = start;
            if (start == end)
                return null;
            while (fast != end && fast.next != end) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }

    }
}
