public class HammingDistance {

    public int hammingDistance(int x, int y) {
        return countOneBit(x ^ y);
    }

    private int countOneBit(int n) {
        int count = 0;

        while (n > 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }
}
