package union.find;

public class Regions_Cut_By_Slashes_959 {
    class Solution {
        public int regionsBySlashes(String[] grid) {
            int n = grid.length;
            DisjointSet<Integer> dsu = new DisjointSet<>();
            for (int i = 0; i < n * n * 4; ++i)
                dsu.makeSet(i);
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (i > 0) {
                        dsu.union(g(i - 1, j, 2, n), g(i, j, 0, n));
                    }
                    if (j > 0) {
                        dsu.union(g(i, j - 1, 1, n), g(i, j, 3, n));
                    }
                    if (grid[i].charAt(j) != '/') {
                        dsu.union(g(i, j, 0, n), g(i, j, 1, n));
                        dsu.union(g(i, j, 2, n), g(i, j, 3, n));
                    }
                    if (grid[i].charAt(j) != '\\') {
                        dsu.union(g(i, j, 0, n), g(i, j, 3, n));
                        dsu.union(g(i, j, 2, n), g(i, j, 1, n));
                    }
                }
            }

            int ans = 0;
            for (int x = 0; x < 4 * n * n; ++x) {
                if (dsu.findSet(x) == x)
                    ans++;
            }

            return ans;
        }

        private int g(int i, int j, int k, int n) {
            return (i * n + j) * 4 + k;
        }
    }
}
