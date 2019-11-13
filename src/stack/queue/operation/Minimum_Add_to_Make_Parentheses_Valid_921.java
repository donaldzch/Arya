package stack.queue.operation;

import java.util.Stack;

public class Minimum_Add_to_Make_Parentheses_Valid_921 {
    class Solution {
        public int minAddToMakeValid(String S) {
            Stack<Character> stack = new Stack<>();

            int count = 0;

            for (int i = 0; i < S.length(); i++) {
                char c = S.charAt(i);
                if (c == '(') {
                    stack.push(c);
                }
                if (c == ')') {
                    if (stack.isEmpty()) {
                        count++;
                    } else {
                        stack.pop();
                    }
                }
            }
            return count + stack.size();
        }
    }
}
