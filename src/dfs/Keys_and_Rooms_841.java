package dfs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Keys_and_Rooms_841 {
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            Set<Integer> visited = new HashSet<>();

            dfs(visited, 0, rooms);

            return visited.size() == rooms.size();
        }

        private void dfs(Set<Integer> visited, int current, List<List<Integer>> rooms) {
            if (visited.contains(current)) {
                return;
            }
            visited.add(current);

            for (int room : rooms.get(current)) {
                dfs(visited, room, rooms);
            }
        }
    }
}
