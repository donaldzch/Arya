package math.operation;

class Escape_The_Ghosts_789 {
    class Solution {
        public boolean escapeGhosts(int[][] ghosts, int[] target) {
            int d = Math.abs(target[0]) + Math.abs(target[1]);

            for (int[] ghost : ghosts) {
                int g = Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1]);
                if (d >= g) {
                    return false;
                }
            }
            return true;
        }
    }
}
             