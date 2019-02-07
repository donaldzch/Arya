package dfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Shopping_Offers_638 {
    class Solution {
        private int min = Integer.MAX_VALUE;

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            dfs(price, special, needs, 0);
            return min;
        }

        private void dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int total) {
            if (hasNeeds(needs)) {
                // process special offer first
                for (List<Integer> s : special) {
                    if (canBeApplied(s, needs)) {
                        dfs(price, special, updateNeeds(needs, s), total + s.get(needs.size()));
                    }
                }
                //process regular one
                for (int i = 0; i < needs.size(); i++) {
                    total += needs.get(i) * price.get(i);
                }
            }
            min = Math.min(min, total);
        }

        private boolean hasNeeds(List<Integer> needs) {
            boolean hasNeeds = false;

            for (Integer need : needs) {
                if (need > 0) {
                    hasNeeds = true;
                    break;
                }
            }
            return hasNeeds;
        }

        private List<Integer> updateNeeds(List<Integer> needs, List<Integer> special) {
            List<Integer> updated = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++) {
                updated.add(needs.get(i) - special.get(i));
            }

            return updated;
        }

        private boolean canBeApplied(List<Integer> special, List<Integer> need) {
            int size = need.size();
            boolean canBeApplied = true;
            for (int i = 0; i < size; i++) {
                if (need.get(i) < special.get(i)) {
                    canBeApplied = false;
                }
            }
            return canBeApplied;
        }
    }

    public static void main(String[] args) throws IOException {

        List<Integer> price = Arrays.asList(2, 5);
        List<List<Integer>> special = Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10));
        List<Integer> needs = Arrays.asList(3, 2);
        int[][] M = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        new Shopping_Offers_638().new Solution().shoppingOffers(price, special, needs);


    }
}
