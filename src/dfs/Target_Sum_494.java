package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Target_Sum_494 {
    class Solution {
        public int findTargetSumWays(int[] nums, int S) {
            int total = 0;

            for (int num : nums) {
                total += num;
            }

            if (S - total > 0 || S + total < 0) {
                return 0;
            }

            int[][] dp = new int[nums.length + 1][2 * total + 1];

            dp[0][total] = 1;

            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j < 2 * total + 1; j++) {
                    if (j - nums[i - 1] >= 0) {
                        dp[i][j] += dp[i - 1][j - nums[i - 1]];
                    }
                    if (j + nums[i - 1] < 2 * total + 1) {
                        dp[i][j] += dp[i - 1][j + nums[i - 1]];
                    }
                }
            }
            return dp[nums.length][total + S];
        }
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int S = Integer.parseInt(line);

            int ret = new Target_Sum_494().new Solution().findTargetSumWays(nums, S);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
