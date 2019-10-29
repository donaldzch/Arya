package string.operation;

class Remove_Outermost_Parentheses_1021 {
    class Solution {
        public String removeOuterParentheses(String S) {
            int top = -1;

            char[] chars = S.toCharArray();

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < chars.length; i++) {
                if (!(top == -1 || (chars[i] == ')' && (top - 1 == -1)))) {
                    sb.append(chars[i]);
                }
                if (chars[i] == '(') {
                    top++;
                } else {
                    top--;
                }
            }

            return sb.toString();
        }
    }
}