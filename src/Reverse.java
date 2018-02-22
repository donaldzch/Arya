import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverse {

    private int reverse(int x) {
        int result = 0;
        try {
            if (x > 0) {
                result = getResult(x);
            } else {
                result = -getResult(-x);
            }
        } catch (Exception ex) {

        }
        return result;
    }

    private Integer getResult(int x) {
        StringBuilder builder = new StringBuilder().append(x).reverse();
        int zeroPos = builder.lastIndexOf("0");
        return Integer.parseInt(builder.substring(zeroPos == -1 ? 0 : zeroPos));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int x = Integer.parseInt(line);

            int ret = new Reverse().reverse(x);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
