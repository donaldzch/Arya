package array.operation;

import static java.util.Arrays.sort;

public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i +=2 ) {
            result += nums[i];
        }
        return result;
    }

    public int arrayPairSum1(int[] nums) {
        int[] bucket = new int[20001];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] + 10000]++;
        }
        int sum = 0;
        boolean odd = true;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                if (odd) {
                    sum += i - 10000;
                }
                odd = !odd;
                bucket[i]--;
            }
        }
        return sum;
    }
}
