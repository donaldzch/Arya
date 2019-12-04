package array.operation;

import java.util.List;
import java.util.Map;

class Intersection_of_Two_Arrays_II_350 {
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            Map<Integer, Integer>  map1 = new HashMap<>();
            for (int num : nums1) {
                map1.put(num, map1.getOrDefault(num, 0) + 1);
            }

            Map<Integer, Integer> map2 = new HashMap<>();

            List<Integer> result = new ArrayList<>();
            for (int num : nums2) {
                if (map1.containsKey(num) && map1.get(num) > 0 ) {
                    result.add(num);
                    map1.put(num, map1.get(num) - 1);
                }
            }

            int[] ans = new int[result.size()];
            for (int i = 0; i < result.size(); i++) {
                ans[i] = result.get(i);
            }

            return ans;
        }
    }
}