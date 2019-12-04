package string.operation;

class Maximum_Number_of_Balloons_1189 {
    class Solution {
        public int maxNumberOfBalloons(String text) {
            int[] balloon = new int[26];

            for (char c : "balloon".toCharArray()) {
                balloon[c - 'a']++;
            }

            int[] balloons = new int[26];

            for (char c : text.toCharArray()) {
                balloons[c - 'a']++;
            }

            int result = text.length();
            for (char c : "balloon".toCharArray()) {
                result = Math.min(result, balloons[c - 'a'] / balloon[c - 'a']);
            }
            return result;
        }
    }
}