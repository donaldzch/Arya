import java.util.Set;

class Fair_Candy_Swap_888 {
    class Solution {
        public int[] fairCandySwap(int[] A, int[] B) {
            int[] result = new int[2];
            int sumA = 0, sumB = 0;

            for (int a : A) {
                sumA += a;
            }

            for (int b : B) {
                sumB += b;
            }

            int diff = (sumB - sumA) / 2;

            Set<Integer> s = new HashSet<>();

            for (int b : B) {
                s.add(b);
            }

            for (int a : A) {
                if (s.contains(diff + a)) {
                    result[0] = a;
                    result[1] = diff + a;
                    break;
                } 
            }
            return result;
        }
    }
}