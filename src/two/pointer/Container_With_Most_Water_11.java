package two.pointer;

class Container_With_Most_Water_11 {
    class Solution {
        public int maxArea(int[] height) {
            int l = 0, r = height.length - 1;
            int max = Integer.MIN_VALUE;

            while (l < r) {
                max = Math.max(max, (r - l) * Math.min(height[l], height[r]));
                if (height[l] < height[r]) {
                    l += 1;
                } else {
                    r -= 1;
                }
            }

            return max;
        }
    }
}