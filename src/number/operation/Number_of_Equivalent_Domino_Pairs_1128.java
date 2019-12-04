package number.operation;

class Number_of_Equivalent_Domino_Pairs_1128 {
    class Solution {
        public int numEquivDominoPairs(int[][] dominoes) {
            int[] count = new int[100];

            int result = 0;

            for (int[] dominoe : dominoes) {
                int index = Math.min(dominoe[0], dominoe[1]) * 10 + Math.max(dominoe[0], dominoe[1]);
                result += count[index]++;
            }

            return result;
        }
    }
}