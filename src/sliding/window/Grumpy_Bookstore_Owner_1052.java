package sliding.window;

class Grumpy_Bookstore_Owner_1052 {
    class Solution {
        public int maxSatisfied(int[] customers, int[] grumpy, int X) {

            int window = 0;

            int maxUnsatisfied = 0;

            int total = 0;

            for (int i = 0; i < customers.length; i++) {
                if (grumpy[i] == 0) {
                    total += customers[i];
                } else {
                    window += customers[i];
                }

                if (i >= X) {
                    window -= grumpy[i - X] * customers[i - X];
                }

                maxUnsatisfied = Math.max(maxUnsatisfied, window);
            }


            return total + maxUnsatisfied;
        }
    }
}