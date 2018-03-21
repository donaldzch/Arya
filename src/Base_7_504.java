import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Base_7_504 {
    public String convertToBase7(int num) {
        if (num == 0) return "0";
        String result = "";
        String sign = num > 0 ? "" : "-";
        num = Math.abs(num);
        while (num > 0) {
            result = num % 7 + result;
            num = num / 7;
        }
        return sign + result;
    }

    final static char[] digits = {
            '0' , '1' , '2' , '3' , '4' , '5' ,
            '6' , '7' , '8' , '9' , 'a' , 'b' ,
            'c' , 'd' , 'e' , 'f' , 'g' , 'h' ,
            'i' , 'j' , 'k' , 'l' , 'm' , 'n' ,
            'o' , 'p' , 'q' , 'r' , 's' , 't' ,
            'u' , 'v' , 'w' , 'x' , 'y' , 'z'
    };
    public String convertToBase71(int num) {
        char buf[] = new char[33];
        boolean negative = (num < 0);
        int charPos = 32;

        if (!negative) {
            num = -num;
        }

        while (num <= -7) {
            buf[charPos--] = digits[-(num % 7)];
            num = num / 7;
        }
        buf[charPos] = digits[-num];

        if (negative) {
            buf[--charPos] = '-';
        }

        return new String(buf, charPos, (33 - charPos));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            String ret = new Base_7_504().convertToBase7(num);

            String out = (ret);

            System.out.print(out);
        }
    }
}
