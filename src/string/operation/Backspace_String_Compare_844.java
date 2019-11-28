package string.operation;

class Backspace_String_Compare_844 {
    class Solution {
        public boolean backspaceCompare(String S, String T) {
            int i = S.length() - 1;
            int j = T.length() - 1;

            int remove1 = 0;
            int remove2 = 0;
            while (i >= 0 || j >= 0) {
                while (i >= 0) {
                    if (S.charAt(i) == '#') {
                        remove1++;
                        i--;
                    } else if (remove1 > 0) {
                        remove1--;
                        i--;
                    } else {
                        break;
                    }
                }
                 
                while (j >= 0) {
                    if (T.charAt(j) == '#') {
                        remove2++;
                        j--;
                    } else if (remove2 > 0) {
                        remove2--;
                        j--;
                    } else {
                        break;
                    }
                }
            
                if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                    i--; j--;
                } else {
                    return i == -1 && j == -1;
                }
            }
            return i == -1 && j == -1;

        }
    }
}