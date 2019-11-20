class Partition_Array_Into_Three_Parts_With_Equal_Sum_1013 {
    class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            int sum = 0;

            for (int a : A) {
                sum += a;
            }
            if ((sum % 3) != 0) {
                return false;
            }

            int partSum = 0;
            int count = 0;
            for (int a : A) {
                partSum += a;
                if (partSum != sum / 3) {
                    continue;
                }
                if (++count == 3) {
                    return true;
                }
                partSum = 0;
            }
            return false;
        }
    }
}