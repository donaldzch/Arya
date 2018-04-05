package bit.operation;

public class Number_of_1_Bits_191 {
    public int hammingWeight(int n) {
        int weight = 0;
        while (n != 0) {
            weight++;
            n = n & (n - 1);
        }
        return weight;
    }

    public int hammingWeight1(int n) {
        int weight = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                weight++;
            n >>>= 1;
        }
        return weight;
    }
}
