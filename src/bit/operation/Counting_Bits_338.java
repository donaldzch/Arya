package bit.operation;

public class Counting_Bits_338 {
    class Solution {
        public int[] countBits(int num) {
            int[] count = new int[num + 1];

            for (int i = 0; i <= num; i++) {
                if (i % 2 == 0) {
                    count[i] = count[i / 2];
                } else {
                    count[i] = count[i - 1] + 1;
                }
            }
            return count;
        }
    }
}
