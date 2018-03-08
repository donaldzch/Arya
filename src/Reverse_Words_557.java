import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse_Words_557 {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();

        for (int i =0, j, k = 0; k <= s.length(); k++) {
            if (chars[k] == ' ' || k == s.length()) {
                j = k - 1;
                while (i < j) {
                    char temp = chars[j];
                    chars[j] = chars[i];
                    chars[i] = temp;
                    i++;
                    j--;
                }
                i = k + 1;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = line;

            String ret = new Reverse_Words_557().reverseWords(s);

            String out = (ret);

            System.out.print(out);
        }
    }
}
