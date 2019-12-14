package two.pointer;

import java.util.Arrays;

class Heaters_475 {
    class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            int result = 0;
            Arrays.sort(houses);
            Arrays.sort(heaters);

            int index = 0;
            for (int house : houses) {
                while (index < heaters.length - 1 && heaters[index] + heaters[index + 1] < 2 * house) {
                    index++;
                }
                result = Math.max(result, Math.abs(heaters[index] - house));
            }

            return result;
        }
    }
}