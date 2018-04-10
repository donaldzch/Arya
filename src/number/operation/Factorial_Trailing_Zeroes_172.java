package number.operation;

public class Factorial_Trailing_Zeroes_172 {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public int trailingZeroes1(int n) {
        int result = 0;

        while (n >= 5) {
            n /= 5;
            result += n;
        }

        return result;
    }
}
