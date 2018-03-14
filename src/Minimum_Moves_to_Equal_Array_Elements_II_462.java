import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Minimum_Moves_to_Equal_Array_Elements_II_462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length/2];
        int minMoves = 0;
        for (int num : nums)
            minMoves += Math.abs(num - median);
        return minMoves;
    }

    public int minMoves21(int[] nums) {
        int median = quickSelect(nums, nums.length/2 + 1, 0, nums.length - 1);
        int minMoves = 0;
        for (int num : nums)
            minMoves += Math.abs(num - median);
        return minMoves;
    }

    private int quickSelect(int[] nums, int k, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        int i = partition(nums, start, end);
        System.out.print("split is : " + i + "\n");
        int length = i - start + 1;

        System.out.print("length is : " + length + " k: " + k + "\n");
        if (length > k) return quickSelect(nums, k, start, i - 1);
        else if (length < k) return quickSelect(nums, k - length, i + 1, end);
        return nums[i];
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];

        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, end, i + 1);
        return i + 1;
    }

    private void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }

    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);

            int ret = new Minimum_Moves_to_Equal_Array_Elements_II_462().minMoves21(nums);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
