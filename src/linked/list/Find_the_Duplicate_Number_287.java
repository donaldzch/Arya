package linked.list;

class Find_the_Duplicate_Number_287 {
    class Solution {
        public int findDuplicate(int[] nums) {
            if (nums.length <= 1) {
                return -1;
            }

            int fast = nums[nums[0]];
            int slow = nums[0];

            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
                fast = nums[fast];
            }

            fast = 0;
            while (fast != slow) {
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;
        }
    }
}