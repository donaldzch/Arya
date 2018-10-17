package dyamic.programming;

public class Unique_Binary_Search_Trees_96 {
    class Solution {
        public int numTrees(int n) {
            int[] G = new int[n + 1];

            G[0] = 1;
            G[1] = 1;

            for (int j = 2; j <= n; j++) {
                for (int i = 1; i <= j; i++) {
                    G[j] += G[i - 1] * G[j - i];
                }
            }

            return G[n];
        }
    }
}
