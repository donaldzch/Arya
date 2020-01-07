package stack.queue.operation;

import java.util.Stack;

class Minimum_Cost_Tree_From_Leaf_Values_1130 {
    class Solution {
        public int mctFromLeafValues(int[] arr) {
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(Integer.MAX_VALUE);

            for (int num : arr) {
                while (stack.peek() <= num) {
                    int mid = stack.pop();
                    result += mid * Math.min(stack.peek(), num);
                }
                stack.push(num);
            }
            if (stack.size() > 2) {
                result += stack.pop() * stack.peek();
            }
            return result;
        }
    }
}