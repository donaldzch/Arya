package math.operation;

class Optimal_Division_553 {
    class Solution {
        public String optimalDivision(int[] nums) {

            if (nums.length == 1) {
                return nums[0] + "";
            }
            if (nums.length == 2) {
                return nums[0] + "/" + nums[1];
            }

            StringBuilder sb = new StringBuilder();
            sb.append(nums[0]).append("/").append("(");

            for (int i = 1; i < nums.length - 1; i++) {
                sb.append(nums[i]).append("/");
            }
            sb.append(nums[nums.length - 1]).append(")");
            return sb.toString();
        }
    }
}