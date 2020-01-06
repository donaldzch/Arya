package stack.queue.operation;

class Maximum_Nesting_Depth_of_Two_Valid_Parentheses_Strings_1111 {
    class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int[] result = new int[seq.length()];

            int depth = 0;

            for (int i = 0; i < seq.length(); i++) {
                if (seq.charAt(i) == '(') {
                    result[i] = ++depth % 2;
                } else {
                    result[i] = depth-- % 2;
                }
            }

            return result;
        }
    }
}