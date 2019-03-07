package linked.list;

public class Flatten_a_Multilevel_Doubly_Linked_List_430 {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    ;

    class Solution {
        public Node flatten(Node head) {
            if (head == null)
                return null;
            Node tail = dfs(head);
            Node result = tail;
            while (tail != null) {
                result = tail;
                tail = tail.prev;
            }
            return result;
        }

        private Node dfs(Node head) {
            if (head == null)
                return null;
            Node p = head;
            Node prev = head;
            Node q;
            while (p != null) {
                if (p.child != null) {
                    q = p.next;
                    p.next = p.child;
                    p.child.prev = p;
                    p.child = null;
                    p = dfs(p.next);
                    p.next = q;
                    if (q != null) {
                        q.prev = p;
                    }
                }
                prev = p;
                p = p.next;
            }
            return prev;
        }
    }
}
