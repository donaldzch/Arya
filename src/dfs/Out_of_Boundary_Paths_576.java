package dfs;

public class Out_of_Boundary_Paths_576 {
    class Solution {
        public int findPaths(int m, int n, int N, int i, int j) {
            int M = 1000000000 + 7;
            int[][] dp = new int[m][n];
            dp[i][j] = 1;
            int count = 0;
            for (int k = 1; k <= N; k++) {
                int[][] temp = new int[m][n];
                for (int s = 0; s < m; s++) {
                    for (int t = 0; t < n; t++) {
                        if (s == m - 1) {
                            count = (count + dp[s][t]) % M;
                        }
                        if (t == n - 1) {
                            count = (count + dp[s][t]) % M;
                        }
                        if (s == 0) {
                            count = (count + dp[s][t]) % M;
                        }
                        if (t == 0) {
                            count = (count + dp[s][t]) % M;
                        }
                        temp[s][t] =
                                (
                                        ((s > 0 ? dp[s - 1][t] : 0) + (s < m - 1 ? dp[s + 1][t] : 0)) % M
                                                + ((t > 0 ? dp[s][t - 1] : 0) + (t < n - 1 ? dp[s][t + 1] : 0)) % M
                                ) % M;
                    }
                }
                dp = temp;
            }
            return count;
        }
    }
}
