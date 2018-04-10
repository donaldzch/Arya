package number.operation;

public class Power_of_Four_342 {
    public boolean isPowerOfFour(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num & 0x55555555) != 0);
    }

    // 4^n equals (3 + 1)^n - 1

    public boolean isPowerOfFour1(int num) {
        return (num > 0) && ((num & (num - 1)) == 0) && ((num - 1) % 3 == 0);
    }
}
