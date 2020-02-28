package string.operation;

class Maximum_Product_of_Word_Lengths_318 {
    class Solution {
        public int maxProduct(String[] words) {
            int[] hash = new int[words.length];

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                for (int j = 0; j < word.length(); j++) {
                    hash[i] |= 1 << (word.charAt(j) - 'a');
                }
            }

            int result = 0;

            for (int i = 0; i < words.length - 1; i++) {
                for (int j = i + 1; j < words.length; j++) {
                    if ((hash[i] & hash[j]) == 0) {
                        result = Math.max(result, words[i].length() * words[j].length());
                    }
                }
            }
            return result;
        }
    }
}