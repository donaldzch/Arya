package bit.operation;

import java.util.*;

public class Prime_Number_of_Set_Bits_in_Binary_Representation762 {
    public int countPrimeSetBits(int L, int R) {
        List<Integer> primeList = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        int result = 0;
        for (int i = L; i <= R; i++) {
            int count = countBits(i);
            if (primeList.contains(count)) {
                result++;
            }
        }
        return  result;
    }

    private int countBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
