package number.operation;

public class Power_of_Three_326 {
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;

        while (n % 3 == 0)
            n /= 3;

        return n == 1;
    }

    public boolean isPowerOfThree1(int n) {
        int maxOfPowerThree = (int) Math.pow(3, (int) (Math.log(Integer.MAX_VALUE) / Math.log(3)));

        return (n > 0) && (maxOfPowerThree % n == 0);
    }
}
