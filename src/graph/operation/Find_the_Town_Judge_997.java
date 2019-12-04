package graph.operation;

class Find_the_Town_Judge_997 {
    class Solution {
        public int findJudge(int N, int[][] trust) {
            int[] trusts = new int[N];
            int[] trusted = new int[N];

            for (int[] t : trust) {
                trusts[t[0]]++;
                trusted[t[1]]++;
            }

            for (int i = 1; i <= N; i++) {
                if (trusts[i] == 0 && trusted[i] == N - 1) {
                    return i;
                }
            }

            return -1;
        }
    }
}