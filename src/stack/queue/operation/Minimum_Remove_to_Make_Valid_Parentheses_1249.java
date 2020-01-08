package stack.queue.operation;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Minimum_Remove_to_Make_Valid_Parentheses_1249 {
    class Solution {
        public String minRemoveToMakeValid(String s) {
            StringBuilder sb = new StringBuilder();

            Stack<Integer> stack = new Stack<>();
            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    } else {
                        set.add(i);
                    }
                }
            }

            while (!stack.isEmpty()) {
                set.add(stack.pop());
            }

            for (int i = 0; i < s.length(); i++) {
                if (!set.contains(i)) {
                    sb.append(s.charAt(i));
                }
            }
            return sb.toString();
        }
    }
}