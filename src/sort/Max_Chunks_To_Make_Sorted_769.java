package sort;

class Max_Chunks_To_Make_Sorted_769 {
    class Solution {
        public int maxChunksToSorted(int[] arr) {
            int max = 0;
            int result = 0;

            for (int i = 0; i < arr.length; i++) {
                 max = Math.max(max, arr[i]);
                 if (max == i) {
                    result++;
                 }
            }
            return result;
        }
    }
}