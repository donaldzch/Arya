package graph.operation;

import java.util.*;

class Queens_That_Can_Attack_the_King_1222 {
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            List<List<Integer>> result = new ArrayList<>();

            boolean[][] seen = new boolean[8][8];

            for (int[] queen : queens) {
                seen[queen[0]][queen[1]] = true;
            }

            int[] dirs = new int[] {-1, 0, 1};

            for (int dx : dirs) {
                for (int dy : dirs) {
                    if (dx == 0 && dy == 0) {
                        continue;
                    }
                    int x = king[0], y = king[1];
                    while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
                        x += dx;
                        y += dy;
                        if (seen[x][y]) {
                            result.add(Arrays.asList(x, y));
                            break;
                        }
                    }
                }
            }
            return result;
        }
    }
}