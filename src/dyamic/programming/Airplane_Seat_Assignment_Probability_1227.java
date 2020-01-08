package dyamic.programming;

class Airplane_Seat_Assignment_Probability_1227 {
    class Solution {
        public double nthPersonGetsNthSeat(int n) {
            double[] dp = new double[n];
            dp[0] = 1.0d;
            for (int i = 1; i < n; i++) {
                dp[i] = 1.0d/(i + 1) + (i + 1 - 2.0)/(i + 1) * dp[i - 1];
            }
            return dp[n - 1];
        }
    }
}