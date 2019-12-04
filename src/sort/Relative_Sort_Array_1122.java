package sort;

public class Relative_Sort_Array_1122 {
    class Solution {
        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] result = new int[arr1.length];

            int[] count = new int[1001];

            for (int n : arr1) {
                count[n]++;
            }

            int i = 0;

            for (int n : arr2) {
                while (count[n]-- > 0) {
                    result[i++] = n;
                }
            }
            for (int j = 0; j < 1001; j++) {
                while (count[j]-- > 0) {
                    result[i++] = j;
                }
            }
            return result;
        }
    }
}
