package array.operation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Longest_Harmonious_Subsequence_594 {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);

        int left = 0, right = 1;

        int result = 0;

        while (right < nums.length) {
            if (nums[right] - nums[left] == 0) {
                right++;
            } else if (nums[right] - nums[left] == 1) {
                result = Math.max(result, right - left + 1);
                right++;
            } else {
                left++;
            }
        }
        return result;
    }

    public int findLHS1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;

        for (int num : map.keySet()) {
            if (map.containsKey(num + 1))
                result = Math.max(result, map.get(num) + map.get(num + 1));
        }

        return result;
    }
}
