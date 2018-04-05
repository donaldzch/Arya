package linked.list;

public class Remove_Duplicates_from_Sorted_List_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode p = head, q = head.next;

        while (q != null) {
            if (p.val == q.val) {
                p.next = q.next;
                q = q.next;
            } else {
                p = p.next;
                q = p.next;
            }
        }
        return head;
    }
}
