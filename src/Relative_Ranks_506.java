import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Relative_Ranks_506 {
    public String[] findRelativeRanks(int[] nums) {
        String[] result = new String[nums.length];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        Arrays.sort(nums);

        if (result.length >= 1)
            result[map.get(nums[nums.length - 1])] = "Golden Medal";
        if (result.length >= 2)
            result[map.get(nums[nums.length - 2])] = "Silver Medal";
        if (result.length >= 3)
            result[map.get(nums[nums.length - 3])] = "Bronze Medal";

        if (result.length >= 4) {
            for (int i = 0; i < nums.length - 3; i++) {
                result[map.get(nums[i])] = String.valueOf(nums.length - i);
            }
        }

        return result;
    }
}
