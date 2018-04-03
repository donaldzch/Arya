package number.operation;

public class Happy_Number_202 {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = nextNumber(slow);
            fast = nextNumber(nextNumber(fast));
            if (fast == 1) return true;
        } while (slow != fast);

        return false;
    }

    private int nextNumber(int number) {
        int sum = 0;

        while (number > 0) {
            sum += (number % 10) * (number % 10);
            number /= 10;
        }
        return sum;
    }
}
