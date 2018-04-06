package number.operation;

public class Valid_Perfect_Square_367 {
    public boolean isPerfectSquare(int num) {
        int value = 1;

        while (num > 0) {
            num -= value;
            value += 2;
        }

        return num == 0;
    }

    public boolean isPerfectSquare1(int num) {
        long low = 0, high = num;

        while (low < high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == num)
                return true;
            else if (mid * mid < num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

    boolean isPerfectSquare2(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) / 2;
        }
        return x * x == num;
    }
}
