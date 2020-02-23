package binary.search;

class Koko_Eating_Bananas_875 {
    class Solution {
        public int minEatingSpeed(int[] piles, int H) {
            int low = 1;
            int high = 0;

            for (int pile : piles) {
                high = Math.max(high, pile);
            }

            while (low < high) {
                int k = low + (high - low) >> 1;
                int countHours = canEat(piles, k);
                if (countHours < H) {
                    high = k + 1;
                } else if (countHours > H) {
                    low = k - 1;
                } else {
                    return k;
                }
            }
            return low;
        }

        private int canEat(int[] piles, int k) {
            int countHours = 0;

            for (int pile : piles) {
                countHours += pile / k;
                if (countHours % pile != 0) {
                    countHours++;
                }
            }
            return countHours;
        }
    }
}