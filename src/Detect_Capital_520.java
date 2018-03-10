import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Detect_Capital_520 {
    public boolean detectCapitalUse(String word) {

        boolean isUpper = Character.isUpperCase(word.charAt(0));
        int count = isUpper ? 1 : 0;
        for (int i = 1; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                count = (count << 1) + 1;
            } else {
                count = count << 1;
            }
        }
        return isUpper ? ((count & (count -1)) == 0 || (count & (count + 1)) == 0) : (count == 0);
    }

    public boolean detectCapitalUse1(String word) {
        int count = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c))
                count++;
        }
        return count == 0 || count == word.length() || (count == 1 && Character.isUpperCase(word.charAt(0)));
    }


    public static String booleanToString(boolean input) {
        return input ? "True" : "False";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String word = line;

            boolean ret = new Detect_Capital_520().detectCapitalUse(word);

            String out = booleanToString(ret);

            System.out.print(out);
        }
    }
}
