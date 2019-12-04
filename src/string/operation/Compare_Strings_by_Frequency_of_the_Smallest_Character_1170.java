package string.operation;

class Compare_Strings_by_Frequency_of_the_Smallest_Character_1170 {
    class Solution {
        public int[] numSmallerByFrequency(String[] queries, String[] words) {
            int[] wordFS = new int[words.length];

            int index = 0;
            for (String word : words) {
                wordFS[index++] = frequency(word);
            }

            int[] result = new int[queries.length];

            index = 0;
            for (String query : queries) {
                int queryF = frequency(query);
                int count = 0;
                for (int wordF : wordFS) {
                    if (wordF > queryF) {
                        count++;
                    }
                }
                result[index++] = count;
            }

            return result;
        }

        private int frequency(String word) {
            int frequncy = 1;
            char c = word.charAt(0);

            for (int i = 1; i < word.length(); i++) {
                char current = word.charAt(i);
                if (c == current) {
                    frequncy++;
                } else if (c - current > 0) {
                    c = current;
                    frequncy = 1;
                }
            }
            return frequncy;
        }
    }
}