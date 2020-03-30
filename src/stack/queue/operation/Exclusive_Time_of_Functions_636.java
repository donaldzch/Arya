package stack.queue.operation;

import java.util.*;

class Exclusive_Time_of_Functions_636 {
    class Solution {
        public int[] exclusiveTime(int n, List<String> logs) {
            int[] result = new int[n];
            Stack<Integer> stack = new Stack<>();
            int previous = 0;
            for (String log : logs) {
                String[] parts = log.split(":");
                int id = Integer.parseInt(parts[0]);
                int current = Integer.parseInt(parts[2]);
                if (parts[1].equals("start")){
                    if (!stack.isEmpty()){
                        result[stack.peek()] += current - previous;
                    }
                    stack.push(id);
                    previous = current;
                } else {
                    result[stack.pop()] += current - previous + 1;
                    previous = current + 1;
                }
            }
            return result;
        }
    }
}