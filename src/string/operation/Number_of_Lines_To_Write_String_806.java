package string.operation;

class Number_of_Lines_To_Write_String_806 {
    class Solution {
        public int[] numberOfLines(int[] widths, String S) {
            int totalWidth = 0;
            int lines = 0;

            for (char c : S.toCharArray()) {
                if (totalWidth + widths[c - 'a'] > 100) {
                    lines++;
                    totalWidth = widths[c - 'a'];
                } else {
                    totalWidth += widths[c - 'a'];
                }
            }

            lines++;

            return new int[] {lines, totalWidth};
        }
    }
}