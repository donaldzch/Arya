package string.operation;

class DI_String_Match_942 {
    class Solution {
        public int[] diStringMatch(String S) {
            int[] result = new int[S.length() + 1];
            int i = 0, j = result.length - 1, k = 0;
            for (char c : S.toCharArray()) {
                if (c == 'I') {
                    result[k] = i;
                    i++;
                }
                if (c == 'D') {
                    result[k] = j;
                    j--;
                }
                k++;
            }
            result[k] = i < j ? j : i;
            return result;
        }
    }
}