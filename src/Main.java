import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Solution().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int remaining = target - nums[i];
            if (hashMap.containsKey(remaining)) {
                return new int[] { hashMap.get(remaining), i};
            }
            hashMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("no solution");
    }

    public int reverse(int x) {
        int result = 0;
        try {
            if (x > 0) {
                result = getResult(x);
            } else {
                result = -getResult(-x);
            }
        } catch (Exception ex) {

        }
        return result;
    }

    private Integer getResult(int x) {
        StringBuilder builder = new StringBuilder().append(x).reverse();
        int zeroPos = builder.lastIndexOf("0");
        return Integer.parseInt(builder.substring(zeroPos == -1 ? 0 : zeroPos));
    }
}
