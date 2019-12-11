package binary.search;

class Sqrt_x_69 {
    class Solution {
        public int mySqrt(int x) {
            int left = 1;
            int right = x;

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (mid > x/mid) {
                    right = mid - 1;
                } else {
                    if (mid + 1 > x / (mid + 1)) {
                        return mid;
                    }
                    left = mid + 1;
                }
            }
            return right;
        }
    }
}