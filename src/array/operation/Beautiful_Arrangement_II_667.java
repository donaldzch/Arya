package array.operation;

class Beautiful_Arrangement_II_667 {
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] result = new int[n];
            for (int i = 0, l = 1, r = n; l <= r; i++) {
                result[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
            }

            return result;
        }
    }
}