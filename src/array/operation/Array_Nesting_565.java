package array.operation;

class Array_Nesting_565 {
    class Solution {
        public int arrayNesting(int[] nums) {
            int result = 0;

            for (int i = 0; i < nums.length; i++) {
                int size = 0;
                for (int j = i; nums[j] != -1; size++) {
                    int temp = nums[j];
                    nums[j] = -1;
                    j = temp;
                }
                result = Math.max(result, size);
            }

            return result;
        }
    }
}