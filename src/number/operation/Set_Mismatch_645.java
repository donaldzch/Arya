package number.operation;

public class Set_Mismatch_645 {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            xor ^= abs ^ (i + 1);
            if (nums[abs - 1] < 0)
                result[0] = abs;
            nums[abs - 1] *= (-1);
        }
        result[1] = xor ^ result[0];
        return result;
    }
}
