package stack.queue.operation;

import java.util.Stack;

public class Valid_Parentheses_20 {
    public boolean isValid(String s) {
        if (s == null || s.length() % 2 == 1)
            return false;
        char[] chars = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (c == '(')
                stack.push(')');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;

        }
        return stack.isEmpty();
    }

    public boolean isValid1(String s) {
        int top = -1;
        char[] chars = new char[s.length()];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '{')
                chars[++top] = '}';
            else if (c == '[')
                chars[++top] = ']';
            else if (c == '(')
                chars[++top] = ')';
            else if (top == -1 || chars[top--] != c)
                return false;
        }
        return top == -1;
    }
}
