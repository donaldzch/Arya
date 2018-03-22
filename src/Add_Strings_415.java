import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Add_Strings_415 {
    public String addStrings(String num1, String num2) {


        char[] result = new char[Math.max(num1.length(), num2.length()) + 1];

        int carry = 0;
        int pos = result.length - 1;

        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        while (index1 >= 0 || index2 >= 0) {
            if (index1 >= 0)
                carry += num1.charAt(index1--) - '0';
            if (index2 >= 0)
                carry += num2.charAt(index2--) - '0';
            result[pos--] = (char)(carry % 10 + '0');
            carry = carry / 10;
        }

        if (carry == 1) {
            result[pos] = '1';
        } else {
            pos++;
        }

        return new String(result, pos, result.length - pos);
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
            String num1 = stringToString(line);
            line = in.readLine();
            String num2 = stringToString(line);

            String ret = new Add_Strings_415().addStrings(num1, num2);

            String out = (ret);

            System.out.print(out);
        }
    }
}
