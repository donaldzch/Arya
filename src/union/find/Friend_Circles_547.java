package union.find;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Friend_Circles_547 {
    class Solution {
        public int findCircleNum(int[][] M) {
            int[] parents = new int[M.length];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }
            int[] ranks = new int[M.length];

            for (int i = 0; i < M.length; i++) {
                for (int j = i + 1; j < M[0].length; j++) {
                    if (M[i][j] == 1) {
                        union(i, j, parents, ranks);
                    }
                }
            }

            for (int i = 0; i < parents.length; i++) {
                find(i, parents);
            }

            Set<Integer> set = new HashSet<>();

            for (int parent : parents) {
                set.add(parent);
            }

            return set.size();
        }

        private int find(int x, int[] parents) {
            if (parents[x] != x) {
                parents[x] = find(parents[x], parents);
            }
            return parents[x];
        }


        private void union(int i, int j, int[] parents, int[] ranks) {
            int x = find(i, parents);
            int y = find(j, parents);
            if (x != y) {
                if (ranks[x] == ranks[y]) {
                    parents[y] = x;
                    ranks[x]++;
                } else if (ranks[x] < ranks[y]) {
                    parents[y] = x;
                    ranks[x]++;
                } else {
                    parents[x] = y;
                    ranks[y]++;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        int[][] M = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        new Friend_Circles_547().new Solution().findCircleNum(M);


    }
}
