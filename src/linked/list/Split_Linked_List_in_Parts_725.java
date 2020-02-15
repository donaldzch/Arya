package linked.list;

class Split_Linked_List_in_Paris_725 {
    class Solution {
        public ListNode[] splitListToParts(ListNode root, int k) {
            ListNode[] result = new ListNode[k];

            int length = 0;

            ListNode head = root;

            while (head != null) {
                length++;
                head = head.next;
            }

            int n = length / k, remain = length % k;

            ListNode current = root;
            ListNode prev = null;

            for (int i = 0; current != null && i < k; i++, remain--) {
                result[i] = current;
                for (int j = 0; j < n + (remain > 0 ? 1 : 0); j++) {
                    if (current != null) {
                        prev = current;
                        current = current.next;
                    }
                }
                prev.next = null;
            }

            return result;
        }
    }
}