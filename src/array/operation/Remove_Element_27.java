package array.operation;

public class Remove_Element_27 {
    public int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public int removeElement1(int[] nums, int val) {
        int index = 0;
        int n = nums.length;
        while (index < n) {
            if (nums[index] == val) {
                nums[index] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                index++;
            }
        }
        return n;
    }
}
