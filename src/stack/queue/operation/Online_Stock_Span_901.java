package stack.queue.operation;

import java.util.*;

class Online_Stock_Span_901 {
    class StockSpanner {

        private Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }
        
        public int next(int price) {
            int result = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                result += stack.pop()[1];
            }
            stack.push(new int[]{price, result});
            return result;
        }
    }
}