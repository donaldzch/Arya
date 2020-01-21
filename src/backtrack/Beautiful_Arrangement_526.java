package backtrack;

class Beautiful_Arrangement_526 {
    class Solution {
        public int countArrangement(int N) {
            boolean[] visited = new boolean[N + 1];
            int[] result = new int[1];
            backtrack(N, 1, visited, result);
            return result[0];
        }

        private void backtrack(int N, int pos, boolean[] visited, int[] result) {
            if (pos > N) {
                result[0]++;
                return;
            }
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && (i % pos == 0 || pos % i == 0)) {
                    visited[i] = true;
                    backtrack(N, pos + 1, visited, result);
                    visited[i] = false;
                }
            }
        }
    }
}