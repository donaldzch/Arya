package union.find;

public class Redundant_Connection_684 {
    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            DisjointSetUnion dsu = new DisjointSetUnion(edges.length + 1);
            int[] res = null;
            for (int[] edge : edges) {
                if (!dsu.union(edge[0], edge[1])) {
                    res = edge;
                    break;
                }
            }
            return res;
        }

        class DisjointSetUnion {
            private int[] parent;
            private int[] rank;

            public DisjointSetUnion(int size) {
                parent = new int[size];
                for (int i = 0; i < size; i++) parent[i] = i;
                rank = new int[size];
            }

            public int find(int x) {
                if (parent[x] != x) {
                    parent[x] = find(parent[x]);
                }
                return parent[x];
            }

            public boolean union(int x, int y) {
                int xp = find(x);
                int yp = find(y);

                if (xp == yp)
                    return false;

                int xr = rank[xp];
                int yr = rank[yp];

                if (xr == yr) {
                    parent[yp] = xp;
                    rank[xp]++;
                } else if (xr > yr) {
                    parent[yp] = xp;
                } else {
                    parent[xp] = yp;
                }

                return true;
            }
        }
    }
}
