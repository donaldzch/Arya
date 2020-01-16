package string.operation;

class Minimum_Swaps_to_Make_Strings_Equal_1247 {
    class Solution {
        public int minimumSwap(String s1, String s2) {
            int x = 0, y = 0;

            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    if (s1.charAt(i) == 'x') {
                        x++;
                    }
                    if (s1.charAt(i) == 'y') {
                        y++;
                    }
                }
            }

            int diff = x + y;

            if (diff % 2 == 1) {
                return -1;
            }

            return diff / 2 + x % 2;
        }
    }
}