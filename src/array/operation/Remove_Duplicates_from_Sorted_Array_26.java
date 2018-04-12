package array.operation;

public class Remove_Duplicates_from_Sorted_Array_26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
