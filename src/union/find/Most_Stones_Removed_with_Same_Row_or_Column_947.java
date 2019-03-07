package union.find;

import java.util.HashMap;
import java.util.Map;

public class Most_Stones_Removed_with_Same_Row_or_Column_947 {
    class Solution {
        Map<Integer, Integer> f = new HashMap<>();
        int islands = 0;

        public int removeStones(int[][] stones) {
            for (int i = 0; i < stones.length; ++i)
                union(stones[i][0], ~stones[i][1]);
            return stones.length - islands;
        }

        public int find(int x) {
            if (f.putIfAbsent(x, x) == null)
                islands++;
            if (x != f.get(x))
                f.put(x, find(f.get(x)));
            return f.get(x);
        }

        public void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (f.get(x) != y) {
                f.put(find(x), find(y));
                islands--;
            }
        }
    }
}
