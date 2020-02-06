package bit.operation;

class Reordered_Power_of_2_869 {
    class Solution {
        public boolean reorderedPowerOf2(int N) {
            long result = count(N);

            for (int i = 31; i >= 0; i--) {
                if (result == count(1 << i)) {
                    return true;
                }
            }
            return false;
        }

        private long count(int N) {
            long result = 0L;

            while (N > 0) {
                result += Math.pow(10, N % 10);
                N /= 10;
            }

            return result;
        }
    }
}