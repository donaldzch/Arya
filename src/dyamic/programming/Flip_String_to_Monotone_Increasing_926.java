package dyamic.programming;

class Flip_String_to_Monotone_Increasing_926 {
    class Solution {
        public int minFlipsMonoIncr(String S) {
            if (S.isEmpty() || S.length() <= 1) {
                return 0;
            }

            int zero = 0;
            int one = 0;

            char[] chars = S.toCharArray();

            for (int i = 0; i < chars.length; i++) {
                one = Math.min(zero, one) + (chars[i] == '1' ? 0 : 1);
                zero += (chars[i] == '0' ? 0 : 1);
            }

            return Math.min(one, zero);
        }
    }
}