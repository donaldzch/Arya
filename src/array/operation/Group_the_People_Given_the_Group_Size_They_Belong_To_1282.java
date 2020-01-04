package array.operation;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Group_the_People_Given_the_Group_Size_They_Belong_To_1282 {
    class Solution {
        public List<List<Integer>> groupThePeople(int[] groupSizes) {
            List<List<Integer>> result = new ArrayList<>();

            Map<Integer, List<Integer>> map = new HashMap<>();

            for (int i = 0; i < groupSizes.length; i++) {
                List<Integer> list;
                if (map.containsKey(groupSizes[i])) {
                    list = map.get(groupSizes[i]);
                } else {
                    list = new ArrayList<>();
                }
                list.add(i);
                if (list.size() == groupSizes[i]) {
                    result.add(list);
                    map.put(groupSizes[i], new ArrayList<>());
                } else {
                    map.put(groupSizes[i], list);
                }
            }

            return result;
        }
    }
}
    