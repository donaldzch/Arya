package greedy;

class Can_Place_Flowers_605 {
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            int count = 0;
            for (int i = 0; i < flowerbed.length; i++) {
                if (flowerbed[i] == 0) {
                    int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
                    int prev = (i == 0) ? 0 : flowerbed[i - 1];

                    if (prev == 0 && next == 0) {
                        count++;
                        flowerbed[i] = 1;
                    }
                }
            }
            return count >= n;
        }
    }
}