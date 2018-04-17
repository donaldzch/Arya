package sliding.window;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Find_All_Anagrams_in_a_String_438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] hashMap = new int[256];

        for (int i = 0; i < p.length(); i++) {
            hashMap[p.charAt(i)]++;
        }

        int left = 0, right = 0, count = p.length();
        List<Integer> result = new ArrayList<>();

        while (right < s.length()) {
            if (hashMap[s.charAt(right)]-- > 0) {
                count--;
            }
            right++;

            while (count == 0) {
                if (right - left == p.length()) {
                    result.add(left);
                }
                if (++hashMap[s.charAt(left)] > 0) {
                    count++;
                }
                left++;
            }
        }
        return result;
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static String integerArrayListToString(List<Integer> nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            Integer number = nums.get(index);
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayListToString(List<Integer> nums) {
        return integerArrayListToString(nums, nums.size());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String p = stringToString(line);

            List<Integer> ret = new Find_All_Anagrams_in_a_String_438().findAnagrams(s, p);

            String out = integerArrayListToString(ret);

            System.out.print(out);
        }
    }
}
