package math.operation;

class Maximum_of_Absolute_Value_Expression_1131 {
    class Solution {
        public int maxAbsValExpr(int[] arr1, int[] arr2) {
            int[] P = {-1, 1};
            int closest = 0;
            int cur = 0;
            int result = 0;

            for (int p : P) {
                for (int q : P) {
                    closest = p * arr1[0] + q * arr2[0] + 0;
                    for (int i = 1; i < arr1.length; i++) {
                        cur = p * arr1[i] + q * arr2[i] + i;
                        result = Math.max(result, cur - closest);
                        closest = Math.min(closest, cur);
                    }
                }
            }

            return result;
        }
    }
}