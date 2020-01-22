package math.operation;

import java.util.*;

class Moving_Stones_Until_Consecutive_1033 {
    class Solution {
        public int[] numMovesStones(int a, int b, int c) {
            int[] stones = new int[] { a, b, c};

            Arrays.sort(stones);

            int maxMoves = stones[2] - stones[0] - 2;

            int minMoves = 2;

            if (stones[2] - stones[1] <= 2 || stones[1] - stones[0] <= 2) {
                minMoves = 1;
            }
            if (stones[2] - stones[0] == 2) {
                minMoves = 0;
            }

            return new int[] {minMoves, maxMoves};
        }
    }
}