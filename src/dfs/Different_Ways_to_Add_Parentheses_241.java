package dfs;

import java.util.*;

class Different_Ways_to_Add_Parentheses_241 {
    class Solution {
        public List<Integer> diffWaysToCompute(String input) {
            return dfs(input, new HashMap<>());
        }

        private List<Integer> dfs(String input, Map<String, List<Integer>> memo) {
            if (memo.get(input) != null) {
                return memo.get(input);
            }

            List<Integer> result = new ArrayList<>();

            for (int i = 0; i < input.length(); i++) {
                char cur = input.charAt(i);

                if (cur == '+' || cur == '-' || cur == '*') {
                    List<Integer> left = dfs(input.substring(0, i), memo);
                    List<Integer> right = dfs(input.substring(i + 1), memo);
                    for (int l : left) {
                        for (int r : right) {
                            int res = 0;
                            switch (cur) {
                                case '+':
                                    res = l + r;
                                    break;
                                case '-':
                                    res = l - r;
                                    break;
                                case '*':
                                    res = l * r;
                                    break;
                            }
                            result.add(res);
                        }
                    }
                }
            }
            if (result.size() == 0) {
                result.add(Integer.parseInt(input));
            }
            memo.put(input, result);
            return result;
        }
    }
}