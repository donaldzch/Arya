package backtrack;

import java.util.ArrayList;
import java.util.List;

class Generate_Parentheses_22 {
    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, new StringBuilder(), 0, 0, n);
            return result;
        }

        private void backtrack(List<String> result, StringBuilder cur, int open, int close, int max) {
            if (cur.length() == 2 * max) {
                result.add(cur.toString());
            }

            if (open < max) {
                backtrack(result, cur.append("("), open + 1, close, max);
            }
            if (close < open) {
                backtrack(result, cur.append(")"), open, close + 1, max);
            }

        }
    }
}