package bit.operation;

class Single_Number_III_260 {
    class Solution {
        public int[] singleNumber(int[] nums) {
            int[] result = {0, 0};

            int diff = 0;

            for (int num : nums) {
                diff ^= num;
            }

            diff &= -diff; 

            for (int num : nums) {
                if ((num & diff) == 0) {
                    result[0] ^= num; 
                } else {
                    result[1] ^= num;
                }
            }

            return result;
        }
    }
}