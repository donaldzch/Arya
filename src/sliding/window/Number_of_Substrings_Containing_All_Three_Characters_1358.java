package sliding.window;

 class Number_of_Substrings_Containing_All_Three_Characters_1358 {
    class Solution {
        public int numberOfSubstrings(String s) {
            int[] count = {0, 0, 0};
            int i = 0;
            int n = s.length();

            int result = 0;

            for (int j = 0; j < n; j++) {
                ++count[s.charAt(j) - 'a'];
                while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                    --count[s.charAt(i++) - 'a'];
                }
                result += i;
            }

            return result;
        }
    }
 }