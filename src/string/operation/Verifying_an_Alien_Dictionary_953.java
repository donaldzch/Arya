package string.operation;

class Verifying_an_Alien_Dictionary_953 {
    class Solution {
        public boolean isAlienSorted(String[] words, String order) {
            int[] indice = new int[26];

            for (int i = 0; i < order.length(); i++) {
                indice[order.charAt(i) - 'a'] = i;
            }

            for (int k = 0; k < words.length - 1; k++) {
                boolean sorted = false;
                for (int i = 0; i < Math.min(words[k].length(), words[k+1].length()); i++) {
                    if (indice[words[k].charAt(i) - 'a'] > indice[words[k + 1].charAt(i)]) {
                        return false;
                    } else if (indice[words[k].charAt(i) - 'a'] < indice[words[k + 1].charAt(i)]) {
                        sorted = true;
                        break;
                    }
                }
                if (!sorted) {
                    if (words[k].length() < words[k+1].length()) {
                        sorted = true;
                    }
                }
                if (!sorted) {
                    return false;
                }
            }
            return true;
        }
    }
}