package binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Find_Positive_Integer_Solution_for_a_Given_Equation_1237 {
    /*
     * // This is the custom function interface.
     * // You should not implement it, or speculate about its implementation
     *
     */
    interface CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y);
    }

    ;

    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> result = new ArrayList<>();
            int low = 1, high = 1001;
            for (int x = 1; x < 1001; x++) {
                int l = low, r = high;
                while (l < r) {
                    int y = (l + r) / 2;
                    if (customfunction.f(x, y) < z) {
                        l = y + 1;
                    } else {
                        r = y;
                    }
                }
                int val = customfunction.f(x, l);
                if (val >= z) {
                    if (val == z) result.add(Arrays.asList(x, l));
                    high = l;
                } else {
                    low = l;
                }
            }
            return result;
        }
    }
}
