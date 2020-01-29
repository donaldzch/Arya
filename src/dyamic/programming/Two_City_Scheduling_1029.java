package dyamic.programming;

import java.util.*;

class Two_City_Scheduling_1029 {
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int N = costs.length / 2;
            int[][] dp = new int[N + 1][N + 1];

            for (int i = 1; i <= N; i++) {
                dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
            }

            for (int j = 1; j <= N; j++) {
                dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
                }
            }
            return dp[N][N];
        }
    }

    class Solution1 {
        public int twoCitySchedCost(int[][] costs) {
            Arrays.sort(costs, new Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return (a[1] - a[0]) - (b[1] - b[0]);
                }
            });

            int result = 0;
            int N = costs.length / 2;

            for (int i = 0; i < N; i++) {
                result += costs[i][1] + costs[costs.length - 1 - i][0];
            }

            return result;
        }
    }
}