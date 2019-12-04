package string.operation;

class Reverse_Only_Letters_917 {
    class Solution {
        public String reverseOnlyLetters(String S) {
            char[] chars = S.toCharArray();
            int i = 0, j = S.length() - 1;

            while (i < j) {
                if (!Character.isLetter(chars[i])) {
                    i++;
                    continue;
                }
                if (!Character.isLetter(chars[j])) {
                    j--;
                    continue;
                }
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
            return String.valueOf(chars);
        }
    }
}