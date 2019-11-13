package array.operation;

class Shortest_Distance_to_a_Character_821 {
    class Solution {
        public int[] shortestToChar(String S, char C) {
            int prev = Integer.MIN_VALUE / 2;

            int[] result = new int[S.length()];

            for (int i = 0; i < S.length(); i++) {
                if (S.charAt(i) == C) {
                    prev = i;
                }
                result[i] = i - prev;
            }

            prev = Integer.MAX_VALUE / 2;

            for (int i = S.length() - 1; i >= 0; i--) {
                if (S.charAt(i) == C) {
                    prev = i;
                }
                result[i] = Math.min(result[i], prev - i);
            }

            return result;
        }
    }
}