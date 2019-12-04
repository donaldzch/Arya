package bit.operation;

class Solution {
    public int binaryGap(int N) {
        int prev = -1, current = -1;
        int pos = 0;
        int gap = 0;

        while (N > 0) {
            if (N % 2 == 1) {
                current = pos;
                if (prev == -1) {
                    prev = pos;
                } else {
                    gap = Math.max(gap, current - prev);
                }
            }
            N = N >> 1;
            pos++;
        }

        return gap;
    }
}

class Solution1 {
    public int binaryGap(int N) {
        int result = 0;

        for (int distance = -32; N > 0; N /=2, distance++) {
            if ((N & 1) == 1) {
                result = Math.max(result, distance);
                distance = 0;
            }
        }

        return result;
    }
}