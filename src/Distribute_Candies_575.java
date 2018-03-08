import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.sort;

public class Distribute_Candies_575 {
    public int distributeCandies(int[] candies) {
        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies)
            kinds.add(candy);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }

    public int distributeCandies1(int[] candies) {
        sort(candies);
        int count = 1;
        for (int i = 1; i < candies.length && count < candies.length / 2; i++) {
            if (candies[i - 1] < candies[i])
                count++;
        }
        return count;
    }
}
