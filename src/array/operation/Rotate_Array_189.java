package array.operation;

class Rotate_Array_189 {
    class Solution {
        public void rotate(int[] nums, int k) {
            if (nums == null || nums.length == 1) {
                return;
            }
        
            k = k % nums.length;

            reserse(nums, 0, nums.length - 1);
            reserse(nums, 0, k - 1);
            reserse(nums, k, nums.length - 1);
        }

        public void reserse(int[] nums, int start, int end) {
            int i = start, j = end;
            
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
    }
}