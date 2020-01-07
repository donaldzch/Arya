package dfs;

class Jump_Game_III_1306 {
    class Solution {
        public boolean canReach(int[] arr, int start) {
            boolean[] visited = new boolean[arr.length];

            return dfs(arr, start, visited);
        }

        private boolean dfs(int[] arr, int start, boolean[] visited) {
            if (start >= 0 || start < arr.length || !visited[start]) {
                int jump = arr[start];
                visited[start] = true;
                return jump == 0 || dfs(arr, start + arr[start], visited) || dfs(arr, start - arr[start], visited);
            }
            return false;
        }
    }
}