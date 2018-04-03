package array.operation;

import java.util.HashMap;
import java.util.Map;

public class Degree_of_an_Array_697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> leftIndice = new HashMap<>();
        Map<Integer, Integer> rightIndice = new HashMap<>();
        int degree = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!map.containsKey(num)) {
                leftIndice.put(num, i);
            }
            rightIndice.put(num, i);
            map.put(num, map.getOrDefault(num, 0) + 1);
            degree = Math.max(degree, map.get(num));
        }
        int result = Integer.MAX_VALUE;
        for (int num : nums) {
            if (map.get(num) == degree) {
                result = Math.min(result, rightIndice.get(num) - leftIndice.get(num) + 1);
            }
        }
        return result;
    }
}
