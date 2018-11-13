package dfs;

import java.util.Stack;

public class Decode_String_394 {
    class Solution {
        public String decodeString(String s) {
            if (s == null || s.length() == 0) {
                return null;
            }

            Stack<Integer> countStack = new Stack<>();
            Stack<String> stringStack = new Stack<>();

            String ans = "";

            int index = 0;
            int count = 0;

            char[] chars = s.toCharArray();

            while (index < chars.length) {
                if (Character.isDigit(chars[index])) {
                    count = count * 10 + (int) (chars[index] - '0');
                } else if (chars[index] == '[') {
                    countStack.push(count);
                    stringStack.push(ans);
                    //reset count
                    count = 0;
                    //reset ans
                    ans = "";
                } else if (chars[index] == ']') {
                    StringBuilder sb = new StringBuilder(stringStack.pop());
                    int repeat = countStack.pop();
                    for (int i = 0; i < repeat; i++) {
                        sb.append(ans);
                    }
                    ans = sb.toString();
                } else {
                    ans += chars[index];
                }
                index++;
            }

            return ans;
        }
    }

    class Solution1 {

        private int index;

        public String decodeString(String s) {
            return dfs(s);
        }

        String dfs(String s) {
            int count = 0;
            StringBuilder sb = new StringBuilder("");

            for (; index < s.length(); index++) {
                char cur = s.charAt(index);
                if (cur == '[') {
                    index++;
                    String str = dfs(s);
                    for (int i = 0; i < count; i++) {
                        sb.append(str);
                    }
                    count = 0;
                } else if (Character.isDigit(cur)) {
                    count = count * 10 + cur - '0';
                } else if (cur == ']') {
                    return sb.toString();
                } else {
                    sb.append(cur);
                }
            }
            return sb.toString();
        }
    }
}
