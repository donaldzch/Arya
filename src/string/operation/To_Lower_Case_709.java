package string.operation;

public class To_Lower_Case_709 {
    public static class Solution {
        public String toLowerCase(String str) {
            char[] chars = str.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c >= 'A' && c <= 'Z') {
                    c = (char)(c + ('a' - 'A'));
                }
                sb.append(c);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        To_Lower_Case_709.Solution solution = new To_Lower_Case_709.Solution();

        solution.toLowerCase("Hello");
    }
}