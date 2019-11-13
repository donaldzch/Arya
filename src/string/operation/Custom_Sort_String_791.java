package string.operation;

public class Custom_Sort_String_791 {
    class Solution {
        public String customSortString(String S, String T) {
            int[] bucket = new int[126];

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < T.length(); i++) {
                bucket[T.charAt(i) - 'a']++;
            }

            for (int i = 0; i < S.length(); i++) {
                while (bucket[S.charAt(i) - 'a']-- > 0) {
                    sb.append(S.charAt(i));
                }
            }

            for (int i = 0; i < 26; i++) {
                while (bucket[i]-- > 0) {
                    sb.append((char) (i + 'a'));
                }
            }
            return sb.toString();
        }
    }
}
