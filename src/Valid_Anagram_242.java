import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Valid_Anagram_242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] chars = new int[26];
        for (int i = 0; i < s.length(); i++) {
            chars[('z' - s.charAt(i))]++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (--chars[('z' - t.charAt(i))] < 0 )
                return false;
        }
        return true;
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input.toString();
    }

    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);
            line = in.readLine();
            String t = stringToString(line);

            boolean ret = new Valid_Anagram_242().isAnagram(s, t);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
