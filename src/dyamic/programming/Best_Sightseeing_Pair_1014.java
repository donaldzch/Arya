package dyamic.programming;

class Best_Sightseeing_Pair_1014 {
    class Solution {
        public int maxScoreSightseeingPair(int[] A) {
            int result = 0;
            int cur = 0;

            for (int i = 0; i < A.length; i++) {
                result = Math.max(result, cur + A[i]);
                cur = Math.max(cur, A[i]) - 1;
            }

            return result;
        }
    }
}