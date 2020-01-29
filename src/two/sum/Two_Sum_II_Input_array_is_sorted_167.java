package two.sum;


public class Two_Sum_II_Input_array_is_sorted_167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 2)
            return result;
        int index1 = 0, index2 = numbers.length - 1;
        while (index1 < index2) {
            int sum = numbers[index1] + numbers[index2];
            if (sum == target) {
                result[0] = index1 + 1;
                result[1] = index2 + 1;
                break;
            }
            if (sum < target)
                index1++;
            else
                index2--;
        }
        return result;
    }
}
