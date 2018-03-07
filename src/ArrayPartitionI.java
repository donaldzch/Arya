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
}
