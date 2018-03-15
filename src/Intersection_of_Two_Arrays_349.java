import java.util.HashSet;
import java.util.Set;

public class Intersection_of_Two_Arrays_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> numSet1 = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();

        for (int num : nums1) {
            numSet1.add(num);
        }

        for (int num : nums2) {
            if (numSet1.contains(num)) {
                resultSet.add(num);
            }
        }

        int[] result =  new int[resultSet.size()];

        int i = 0;
        for (int num : resultSet) {
            result[i++] = num;
        }


        return result;
    }
}
