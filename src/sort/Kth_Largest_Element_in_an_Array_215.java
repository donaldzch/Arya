package sort;

class Kth_Largest_Element_in_an_Array_215 {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int l = 0;
            int r = nums.length - 1;

            k = nums.length - k;

            while (l < r) {
                int p = partition(nums, l, r);
                if (p < k) {
                    l = p + 1;
                } else if (p > k) {
                    r = p - 1;
                } else {
                    break;
                }
            }
            return nums[k];
        }

        private int partition(int[] nums, int left, int right) {
            int p = left;

            int pivot = nums[right];
            for (int i = left; i < right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, i, p);
                    p++;
                }
            }
            swap(nums, p, right);
            return p;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}