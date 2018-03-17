import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Minimum_Index_Sum_of_Two_Lists_599 {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        int minSum = Integer.MAX_VALUE;

        List<String> result = new ArrayList<>();

        for (int i = 0; i < list2.length; i++) {
            Integer index = map.get(list2[i]);
            if (index != null) {
                if (index + i < minSum) {
                    result.clear();
                    result.add(list2[i]);
                    minSum = index + i;
                } else if (index + i == minSum) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }
}
