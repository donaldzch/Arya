package linked.list;

import java.util.*;

class Add_Two_Numbers_II_445 {
    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            while (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }

            ListNode head = new ListNode(0);

            int sum = 0;
            
            while(!s1.isEmpty() || !s2.isEmpty()) {
                if (!s1.isEmpty()) {
                    sum += s1.pop();
                }
                if (!s2.isEmpty()) {
                    sum += s2.pop();
                }
                ListNode node = new ListNode(sum % 10);
                node.next = head.next;
                head.next = node;
                sum = sum / 10;
            }

            if (sum == 1) {
                head.val = 1;
            }

            return sum == 1 ? head : head.next;
        }
    }
}