package math.operation;

class Largest_Time_for_Given_Digit_949 {
    class Solution {
        public String largestTimeFromDigits(int[] A) {
            int largestTime = -1;

            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A.length; j++) {
                    if (i != j) {
                        for (int k = 0; k < A.length; k++) {
                            if (k != i & k != j) {
                                int l = 6 - i - j - k;

                                int hours = A[i] * 10 + A[j];
                                int minutes = A[k] * 10 + A[l];

                                if (hours < 24 && minutes < 60) {
                                    largestTime = Math.max(largestTime, hours * 60 + minutes);
                                }
                            }
                        }
                    }
                }
            }

            return largestTime == -1 ? "" : String.format("%02d:%02d",largestTime/60,largestTime%60);
        }
    }
}