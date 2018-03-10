public class Binary_Number_with_Alternating_Bits_693 {
    public boolean hasAlternatingBits(int n) {
        return ((n ^= (n >>> 2)) & (n - 1)) == 0;
    }

    public boolean hasAlternatingbits(int n) {
        int cur = n & 1;

        while (n > 0) {
            n = n >>> 1;
            if (cur == (n & 1))
                return false;
            cur = n & 1;
        }
        return true;
    }
}
