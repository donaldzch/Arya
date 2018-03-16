import java.util.HashSet;
import java.util.Set;

public class Contains_Duplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 1)
            return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);
        return set.size() != nums.length;
    }
}
