package bit.operation;

public class Sum_of_Two_Integers_371 {
    public int getSum(int a, int b) {
        if (b == 0)
            return a;
        if (a == 0)
            return b;
        while (b != 0) {
            int c = a & b;
            a = a ^ b;
            b = c << 1;
        }
        return a;
    }

    public int getSum1(int a, int b) {
        return (b == 0) ? a : getSum1(a ^ b,  (a & b) << 1);
    }
}
