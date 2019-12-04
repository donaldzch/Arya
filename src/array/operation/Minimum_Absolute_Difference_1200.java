package array.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Minimum_Absolute_Difference_1200 {
    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(arr);

            int minDiff = Integer.MAX_VALUE;

            for (int i = 0; i < arr.length - 1; i++) {
                int diff = arr[i + 1] - arr[i];
                if (minDiff > diff) {
                    minDiff = diff;
                    result = new ArrayList<>();
                    result.add(Arrays.asList(arr[i], arr[i + 1]));
                } else if (minDiff == diff) {
                    result.add(Arrays.asList(arr[i], arr[i + 1]));
                }
            }
            return result;
        }
    }
}
