package linked.list;

public class Merge_Two_Sorted_Lists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1), node = head;
        ListNode p = l1, q = l2;

        while (p != null && q != null) {
            if (p.val <= q.val) {
                node.next = new ListNode(p.val);
                p = p.next;
            } else {
                node.next = new ListNode(q.val);
                q = q.next;
            }
            node = node.next;
        }

        ListNode r = p == null ? q : p;

        while (r != null) {
            node.next = new ListNode(r.val);
            r = r.next;
            node = node.next;
        }

        head = head.next;
        return head;
    }
}
