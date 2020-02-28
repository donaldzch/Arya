import java.util.*;

class Brick_Wall_554 {
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
           Map<Integer, Integer> map = new HashMap<>();

           int count = 0;

           for (List<Integer> w : wall) {
               int length = 0;
               for (int i = 0; i < w.size() - 1; i++) {
                   length += w.get(i);
                   map.put(length, map.getOrDefault(length, 0) + 1);
                    count = Math.max(count, map.get(length));
               }
           }
           return wall.size() - count;
        }
    }
}