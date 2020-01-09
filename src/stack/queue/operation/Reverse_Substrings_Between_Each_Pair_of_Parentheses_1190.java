package stack.queue.operation;

import java.util.Stack;

class Reverse_Substrings_Between_Each_Pair_of_Parentheses {
    class Solution {
        public String reverseParentheses(String s) {
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            int[] pair = new int[n];

            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    stack.push(i);
                } else if (s.charAt(i) == ')') {
                    int j = stack.pop();
                    pair[i] = j;
                    pair[j] = i;
                }
            }

            for (int i = 0, direction = 1; i < n; i += direction) {
                if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                    i = pair[i];
                    direction = -direction;
                } else {
                    sb.append(s.charAt(i));
                }
            }

            return sb.toString();
        }
    }
}