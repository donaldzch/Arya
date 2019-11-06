package binary.search;

class Peak_Index_in_a_Mountain_Array_852 {
    class Solution {
        public int peakIndexInMountainArray(int[] A) {
            int low = 0, high = A.length - 1;

            while (low < high) {
                int mid = (low + high) / 2;
                
                if (A[mid] < A[mid + 1]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }
}