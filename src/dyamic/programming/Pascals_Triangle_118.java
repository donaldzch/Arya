package dyamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pascals_Triangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = new ArrayList<>();
            prev.add(0);
            prev.addAll(result.get(i - 1));
            prev.add(0);
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < prev.size(); j++) {
                row.add(prev.get(j) + prev.get(j + 1));
            }
            result.add(row);
        }
        return result;
    }
}
