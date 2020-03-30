package dyamic.programming;

import java.util.*;

 class Video_Stitching_1024 {
    class Solution {
        public int videoStitching(int[][] clips, int T) {
            int[] dp = new int[T + 1];

            Arrays.fill(dp, T + 1);

            dp[0] = 0;

            for (int i = 1; i <= T; i++) {
                for (int[] clip : clips) {
                    if (i >= clip[0] && i <= clip[1]) {
                        dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                    }
                }
            }

            return dp[T] == T + 1 ? -1 : dp[T];
        }
    }

    class Solution1 {
        //[0, 2], [1, 5], [1,9], [4,6], [5,9], [8,10]
        public int videoStitching(int[][] clips, int T) {
            Arrays.sort(clips, (a, b) -> a[0] - b[0]);
            int result = 0;

            for (int i = 0, start = 0, end = 0; start <= T; start = end, result++) {
                for (; i < clips.length && clips[i][0] <= start; i++) {
                    end = Math.max(clips[i][1], end);
                }
                if (start == end) {
                    return -1;
                }
            }
            return result;
        }
    }
 }