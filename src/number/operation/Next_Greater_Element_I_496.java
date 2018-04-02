package number.operation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Next_Greater_Element_I_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();

        Map<Integer, Integer> map = new HashMap<>();

        int[] nexts = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty() && stack.peek() < nums2[i])
                map.put(stack.pop(), nums2[i]);
            stack.push(nums2[i]);
        }

        for (int j = 0; j < nums1.length; j++)
            nexts[j] = map.getOrDefault(nums1[j], -1);

        return nexts;
    }
}
