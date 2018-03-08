import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number_Complement_476 {
    public int findComplement(int num) {
        int result = 0;
        int i = 0;
        while (num > 0) {
            if ((num & 1) == 0)
                result |= 1 << i;
            num = num >>> 1;
            i++;
        }
        return result;
    }

    public int findComplement1(int num) {
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        num = ~num;
        return num & mask;
    }

    public int findComplement2(int num) {
        int mask = Integer.highestOneBit(num) - 1;
        num = ~num;
        return num & mask;
    }
    public int findComplement3(int num) {
        int n = 0;
        while (n < num) {
            n = (n << 1) | 1;
        }
        return n - num;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int num = Integer.parseInt(line);

            int ret = new Number_Complement_476().findComplement1(num);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
