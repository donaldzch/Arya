package stack.queue.operation;

class Score_of_Parentheses_856 {
    class Solution {
        public int scoreOfParentheses(String S) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (char c : S.toCharArray()) {
                if (c == '(') {
                    stack.push(0);
                } else {
                    int cur = stack.pop();
                    int prev = stack.pop();
                    stack.push(prev + Math.max(cur * 2, 1));
                }
            }
            return stack.pop();
        }
    }

    class Solution1 {
        public int scoreOfParentheses(String S) {
            int result = 0, depth = 0;
            for (int i = 0; i < S.length(); ++i) {
                if (S.charAt(i) == '(') {
                    depth++;
                } else {
                    depth--;
                    if (S.charAt(i-1) == '(') {
                        result += 1 << depth;
                    }
                }
            }

            return result;
        }
    }
}