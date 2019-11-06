package string.operation;

class Split_a_String_in_Balanced_Strings_1221 {
    class Solution {
        public int balancedStringSplit(String s) {
            int result = 0;
            char[] chars = s.toCharArray();
            int countL = 0;
            int countR = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == 'L') {
                    countL++;
                } 
                if (chars[i] == 'R') {
                    countR++;
                }
                if (countL == countR) {
                    result++;
                    countL = 0;
                    countR = 0;
                }
            }
            return result;
        }
    }
}