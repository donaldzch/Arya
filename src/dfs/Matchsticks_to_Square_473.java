package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Matchsticks_to_Square_473 {
    public class Solution {
        public boolean makesquare(int[] nums) {
            if (nums == null || nums.length < 4)
                return false;

            int sum = 0;

            for (int num : nums) {
                sum += num;
            }

            if (sum % 4 != 0) {
                return false;
            }

            Arrays.sort(nums);

            boolean[] visited = new boolean[nums.length];

            return dfs(nums, nums.length - 1, sum / 4, new int[4], visited);
        }

        private boolean dfs(int[] nums, int index, int target, int[] sums, boolean[] visited) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
                return true;
            }

            for (int i = 0; i < sums.length; i++) {
                if (!visited[index]) {
                    if (sums[i] + nums[index] <= target) {
                        sums[i] += nums[index];
                        visited[index] = true;
                        if (dfs(nums, index - 1, target, sums, visited)) {
                            return true;
                        }
                        sums[i] -= nums[index];
                        visited[index] = false;
                    }
                }
            }

            return false;
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

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            boolean ret = new Matchsticks_to_Square_473().new Solution().makesquare(nums);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
