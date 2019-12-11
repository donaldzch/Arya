package binary.search;

class Sum_of_Square_Numbers_633 {
    class Solution {
        public boolean judgeSquareSum(int c) {
            int left = 0;
            int right = (int)Math.sqrt(c);

            while (left <= right) {
                int square = left * left + right * right;
                if (square < c) {
                    left++;
                } else if (square > c) {
                    right--;
                } else {
                    return true;
                }
            }

            return false;
        }
    }
}