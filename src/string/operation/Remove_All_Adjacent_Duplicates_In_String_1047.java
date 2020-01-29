package string.operation;

import java.util.Stack;

class Remove_All_Adjacent_Duplicate_In_String_1047 {
    class Solution {
        public String removeDuplicates(String S) {
            Stack<Character> stack = new Stack<>();


            for(int i = 0; i < S.length(); i++) {
                if (!stack.isEmpty() && stack.peek() == S.charAt(i)) {
                    stack.pop();
                } else {
                    stack.push(S.charAt(i));
                }
            }

            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }

            return result.reverse().toString();
        }
    }

    class Solution1 {
        public String removeDuplicaString(String S) {
            char[] chars = new char[S.length()];

            int top = 0;

            for (int i = 0; i < S.length(); i++) {
                if (top == 0) {
                    chars[top++] = S.charAt(i);
                } else {
                    if (chars[top - 1] == S.charAt(i)) {
                        top--;
                    } else {
                        chars[top++] = S.charAt(i);
                    }
                }
            }
            return String.valueOf(chars, 0, top + 1);
        }
    }
}

