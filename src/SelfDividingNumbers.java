import java.util.ArrayList;
import java.util.List;

public class SelfDividingNumbers {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> numbers = new ArrayList<>();
        for (int num = left; num < right; num++) {
            if (isDividingNumber(num)) numbers.add(num);
        }
        return numbers;
    }

    private boolean isDividingNumber(int n) {
        int b = n % 10, num = n;
        while (b != 0 && n % b == 0) {
            num = num / 10;
            b = num % 10;
        }
        return num == 0;
    }

    public boolean selfDividing(int n) {
        for (char c: String.valueOf(n).toCharArray()) {
            if (c == '0' || (n % (c - '0') > 0))
                return false;
        }
        return true;
    }

    public boolean selfDividing1(int n) {
        int x = n;
        while (x > 0) {
            int d = x % 10;
            x /= 10;
            if (d == 0 || (n % d) > 0) return false;
        }
        return true;
    }
}
