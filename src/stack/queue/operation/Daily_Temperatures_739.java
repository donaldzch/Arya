package stack.queue.operation;

import java.util.Stack;

public class Daily_Temperatures_739 {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }

        return result;
    }
}
