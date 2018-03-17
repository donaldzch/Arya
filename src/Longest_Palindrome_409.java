import java.util.HashSet;
import java.util.Set;

public class Longest_Palindrome_409 {
    public int longestPalindrome(String s) {
        int[] counts = new int[128];
        for (char c : s.toCharArray())
            counts[c]++;

        int result = 0;

        for (int count: counts) {
            result += count / 2 * 2;
            if (result % 2 == 0 && count % 2 == 1)
                result++;
        }
        return result;
    }

    public int longestPalindrome1(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c))
                set.remove(c);
            else
                set.add(c);
        }

        return s.length() - (set.size() == 0 ? 0 : set.size() - 1);
    }
}
