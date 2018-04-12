package number.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add_Binary_67 {
    public String addBinary(String a, String b) {

        int length = Math.max(a.length(), b.length());

        char[] result = new char[length + 1];

        int offset = result.length - 1;

        int carry = 0;

        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            if (i >= 0)
                carry += a.charAt(i) - '0';
            if (j >= 0)
                carry += b.charAt(j) - '0';
            result[offset--] = (char) ('0' + carry % 2);
            carry /= 2;
        }

        if (carry == 1)
            result[offset--] = '1';

        return new String(result, ++offset, result.length - offset);
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
            String a = stringToString(line);
            line = in.readLine();
            String b = stringToString(line);

            String ret = new Add_Binary_67().addBinary(a, b);

            String out = (ret);

            System.out.print(out);
        }
    }
}
