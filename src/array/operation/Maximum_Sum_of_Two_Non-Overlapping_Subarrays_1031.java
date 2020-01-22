package array.operation;

class Maximum_Sum_of_Two_Non_Overlapping_Subarrays_1031 {
    class Solution {
        public int maxSumTwoNoOverlap(int[] A, int L, int M) {
            int result = 0;

            int Lsum = 0, Lmax = 0, Msum = 0, Mmax = 0;

            for (int i = 0; i < A.length; i++) {
                Msum += A[i];
                if (i >= M) {
                    Msum -= A[i - M];
                }
                if (i >= M) {
                    Lsum += A[i - M];
                }
                if (i >= L + M) {
                    Lsum -= A[i - L - M];
                }
                Lmax = Math.max(Lmax, Lsum);
                result = Math.max(result, Lmax + Msum);
            }

            Lsum = Lmax = Msum = Mmax = 0;
            for (int i = 0; i < A.length; i++) {
                Lsum += A[i];
                if (i >= L) {
                    Lsum -= A[i - L];
                }
                if (i >= L) {
                    Msum += A[i - L];
                }
                if (i >= L + M) {
                    Msum -= A[i - L - M];
                }
                Mmax = Math.max(Msum, Mmax);
                result = Math.max(result, Mmax + Lsum);
            }

            return result;
        }
    }
}