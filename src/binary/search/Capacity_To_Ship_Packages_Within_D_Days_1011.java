package binary.search;

class Capacity_To_Ship_Packages_Within_D_Days_1011 {
    class Solution {
        public int shipWithinDays(int[] weights, int D) {
            int left = 0, right = 0;

            for (int weight : weights) {
                left = Math.max(left, weight);
                right += weight;
            }

            while (left < right) {
                int mid = (left + right) / 2;
                int currentWeight = 0;
                int days = 1;

                for (int weight : weights) {
                    if (currentWeight + weight > mid) {
                        days += 1;
                        currentWeight = 0;
                    }
                    currentWeight += weight;
                }

                if (days > D) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}