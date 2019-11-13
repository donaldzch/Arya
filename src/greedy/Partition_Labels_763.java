package greedy;

import java.util.ArrayList;
import java.util.List;

public class Partition_Labels_763 {
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] lastMap = new int[26];
            for (int i = 0; i < S.length(); i++) {
                lastMap[S.charAt(i) - 'a'] = i;
            }

            List<Integer> result = new ArrayList<>();

            int start = 0;
            int last = 0;

            for (int i = 0; i < S.length(); i++) {
                last = Math.max(last, lastMap[S.charAt(i) - 'a']);
                if (i == last) {
                    result.add(last - start + 1);
                    start = i + 1;
                }
            }

            return result;
        }
    }
}
