package linked.list;

public class Palindrome_Linked_List_234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode fast = head, slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null)
            slow = slow.next;

        slow = reverseList(slow);

        fast = head;

        while (fast != null && slow != null) {
            if (fast.val != slow.val)
                return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode p = head, q = head.next;

        while (q != null) {
            ListNode r = q.next;
            q.next = p;
            p = q;
            q = r;
        }

        head.next = null;
        head = p;

        return head;
    }
}
