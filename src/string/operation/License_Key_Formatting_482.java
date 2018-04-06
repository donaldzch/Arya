package string.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class License_Key_Formatting_482 {
    public String licenseKeyFormatting(String S, int K) {
        char[] chars = S.toCharArray();
        char[] result = new char[chars.length * 2];

        int index = chars.length - 1, pos = result.length - 1;

        int length = 0;

        while (index >= 0) {
            if (chars[index] != '-') {
                result[pos--] = Character.toUpperCase(chars[index]);
                length++;
            }
            if (length == K && index - 1 >= 0 && chars[index - 1] != '-') {
                length = 0;
                result[pos--] = '-';
            }
            index--;
        }
        return new String(result, ++pos, result.length - pos);
    }

    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String S = stringToString(line);
            line = in.readLine();
            int K = Integer.parseInt(line);

            String ret = new License_Key_Formatting_482().licenseKeyFormatting(S, K);

            String out = (ret);

            System.out.print(out);
        }
    }
}
