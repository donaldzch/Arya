package string.operation;

import java.io.IOException;

public class Complex_Number_Multiplication_537 {
    class Solution {
        public String complexNumberMultiply(String a, String b) {
            String[] first = a.split("\\+|i");
            String[] second = b.split("\\+|i");

            int A = Integer.parseInt(first[0]);
            int B = Integer.parseInt(first[1]);
            int C = Integer.parseInt(second[0]);
            int D = Integer.parseInt(second[1]);

            return (A * C - B * D) + "+" + (A * D + B * C) + "i";
        }
    }

    public static void main(String[] args) throws IOException {
        String a = "1+1i";
        String b = "1+2i";

        new Complex_Number_Multiplication_537().new Solution().complexNumberMultiply(a, b);
    }
}

