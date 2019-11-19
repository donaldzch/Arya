package two.pointer;

class Duplicate_Zeros_1089 {
    class Solution {
        public void duplicateZeros(int[] arr) {
            int countZeros = 0;
            
            for (int num : arr) {
                if (num == 0) {
                    countZeros++;
                }
            }

            int totalLength = arr.length + countZeros;

            for (int i = arr.length - 1, j = totalLength - 1; i < j; i--, j--) {
                if (arr[i] != 0) {
                    if (j < arr.length) {
                        arr[j] = arr[i];
                    }
                } else {
                    if (j < arr.length) {
                        arr[j] = arr[i];
                    }
                    j--;
                    if (j < arr.length) {
                        arr[j] = arr[i];
                    }
                }
            }
        }
    }
}