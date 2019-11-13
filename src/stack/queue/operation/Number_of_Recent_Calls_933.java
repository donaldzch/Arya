package stack.queue.operation;

import java.util.Deque;
import java.util.LinkedList;

public class Number_of_Recent_Calls_933 {
    class RecentCounter {

        private Deque<Integer> deque;

        public RecentCounter() {
            this.deque = new LinkedList<Integer>();
        }

        public int ping(int t) {
            while (!deque.isEmpty() && deque.peekFirst() < t - 3000)
                deque.removeFirst();

            deque.addLast(t);
            return deque.size();
        }
    }
}
