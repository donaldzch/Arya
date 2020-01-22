package math.operation;

import java.util.*;

class Beautiful_Array_932 {
    class Solution {
        public int[] beautifulArray(int N) {
            List<Integer> result = new ArrayList<>();
            result.add(1);

            int size = result.size();

            while (size < N) {
                List<Integer> temp = new ArrayList<>();
                for (int num : result) {
                    if (num * 2 - 1 <= N) {
                        temp.add(num * 2 - 1);
                    }
                }
                for (int num : result) {
                    if (num * 2 <= N) {
                        temp.add(num * 2);
                    }
                }
                result = temp;
                size = result.size();
            }

            int[] ans = new int[result.size()];

            for (int i = 0; i < ans.length; i++) {
                ans[i] = result.get(i);
            }
            return ans;
        }
    }
}