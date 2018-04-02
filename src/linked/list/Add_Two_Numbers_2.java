package linked.list;

import java.util.List;

public class Add_Two_Numbers_2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            if (carry != 0) {
                return new ListNode(carry);
            }
            return null;
        }
        int val1 = l1 == null ? 0 : l1.val;
        int val2 = l2 == null ? 0 : l2.val;

        int val = val1 + val2 + carry;

        ListNode sum = new ListNode(val%10);

        sum.next = addTwoNumbers(l1 == null ? null : l1.next, l2 == null ? null : l2.next, val/10);

        return sum;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode head = new ListNode(-1);
        ListNode current = head;
        int carry = 0;

        while ( p != null || q != null) {
            int s = (p == null) ? 0 : p.val;
            int t = (q == null) ? 0 : q.val;

            int sum = s + t + carry;
            carry = sum / 10;
            current = new ListNode(sum);
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        return head.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode current = head;

        int carry = 0;

        while (l1 != null || l2 !=null || carry !=0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(carry%10);
            carry = carry/10;
            current = current.next;
        }
        return head.next;
    }
}
