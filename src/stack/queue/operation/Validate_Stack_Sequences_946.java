package stack.queue.operation;

import java.util.Stack;

class Validate_Stack_Sequences_946 {
    class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            int count = 0;

            Stack<Integer> stack = new Stack<>();

            for (int push : pushed) {
                stack.push(push);

                while (!stack.isEmpty() && stack.peek() == popped[count]) {
                    stack.pop();
                    count++;
                }
            }
            return count == popped.length;
        }
    }
}