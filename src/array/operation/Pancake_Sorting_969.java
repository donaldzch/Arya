package array.operation;

import java.util.ArrayList;
import java.util.List;

public class Pancake_Sorting_969 {
    class Solution {
        public List<Integer> pancakeSort(int[] A) {
            List<Integer> result = new ArrayList<>();

            for (int largest = A.length, index; largest > 0; largest--) {
                for (index = 0; A[index] != largest; index++) ;
                reverse(A, index + 1);
                result.add(index + 1);
                reverse(A, largest);
                result.add(largest);
            }

            return result;
        }

        public void reverse(int[] A, int k) {
            for (int i = 0, j = k - 1; i < j; i++, j--) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
    }
}
