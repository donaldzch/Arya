package treemap;

class Hand_of_Straights_846 {
    class Solution {
        public boolean isNStraightHand(int[] hand, int W) {
            int[] nums = new int[W];
            for (int i : hand) {
                nums[i%W]++;
            }
            int num = hand.length / W;
            for (int i : nums) {
                if (i != num) {
                    return false;
                }
            }
            return true;
        }
    }
}