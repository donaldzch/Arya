package stack.queue.operation;

import java.util.Stack;

public class Min_Stack_155 {
    class MinStack {

        int min = Integer.MAX_VALUE;
        Stack<Integer> stack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (min == stack.pop())
                min = stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }

}
