package stack.queue.operation;

import java.util.*;

class Check_If_Word_Is_Valid_After_Substitutions_1003 {
    class Solution {
        public boolean isValid(String S) {
            Stack<Character> stack = new Stack<>();

            for (char c : S.toCharArray()) {
                if (c == 'c') {
                    if (!stack.isEmpty() && stack.pop() != 'b') {
                        return false;
                    }
                    if (!stack.isEmpty() && stack.pop() != 'a') {
                        return false;
                    }
                } else {
                    stack.push(c);
                }

            }
            return stack.isEmpty();
        }
    }
}