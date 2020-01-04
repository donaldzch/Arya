package binary.tree;

class Path_In_Zigzag_Labelled_Binary_Tree_1104 {
    class Solution {
        public List<Integer> pathInZigZagTree(int label) {
            List<Integer> result = new ArrayList<>();

            int level = 0;
            while (1 << level <= label) {
                ++level;
            }
            for(; label >= 1; label /= 2, --level) {
                result.add(0, label);
                label = (1 << level) - 1 - label + (1 << (level - 1));
            }

            return result;
        }
    }
}