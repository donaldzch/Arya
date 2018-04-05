package number.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Convert_a_Number_to_Hexadecimal_405 {

    char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        if (num == 0) return "0";
        char buf[] = new char[8];
        int charPos = 7;

        while (num != 0) {
            buf[charPos--] = digits[(num & 15)];
            num >>>= 4;
        }

        return new String(buf, ++charPos, (8 - charPos));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            String ret = new Convert_a_Number_to_Hexadecimal_405().toHex(num);

            String out = (ret);

            System.out.print(out);
        }
    }
}
