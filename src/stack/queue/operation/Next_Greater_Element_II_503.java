package stack.queue.operation;

import java.util.Arrays;
import java.util.Stack;

class Next_Greater_Element_II_503 {
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int[] result = new int[nums.length];
            Arrays.fill(result, -1);

            Stack<Integer> indices = new Stack<>();

            for (int i = 0; i < 2 * nums.length; i++) {
                while(!indices.isEmpty() && nums[indices.peek()] < nums[i % nums.length]) {
                    result[indices.pop()] = nums[i % nums.length];
                }
                indices.push(i % nums.length);
            }

            return result;
        }
    }
}