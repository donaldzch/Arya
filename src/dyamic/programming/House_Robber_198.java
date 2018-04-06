package dyamic.programming;

public class House_Robber_198 {
    public int rob(int[] nums) {
        int dp0 = 0, dp1 = 0;

        for (int num : nums) {
            int dp00 = Math.max(dp0, dp1);
            int dp11 = num + dp0;
            dp0 = dp00;
            dp1 = dp11;
        }
        return Math.max(dp0, dp1);
    }
}
