package dyamic.programming;

public class Climbing_Stairs_70 {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        int p = 1, q = 2;

        for (int i = 3; i <= n; i++) {
            int r = p + q;
            p = q;
            q = r;
        }

        return q;
    }
}
