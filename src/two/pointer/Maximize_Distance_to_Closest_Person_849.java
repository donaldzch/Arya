package two.pointer;

class Maximize_Distance_to_Closest_Person_849 {
    class Solution {
        public int maxDistToClosest(int[] seats) {
            int last = -1;

            int max = 0;

            for (int i = 0; i < seats.length; i++) {
                if (seats[i] == 1) {
                    if (last == -1) {
                        max = i;
                    } else {
                        max = Math.max(max, (i - last) / 2);
                    }
                    last = i;
                }
            }

            if (last != seats.length - 1) {
                max = Math.max(max, seats.length - 1 - last);
            }

            return max;
        }
    }
}