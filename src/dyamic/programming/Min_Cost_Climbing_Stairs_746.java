package dyamic.programming;

public class Min_Cost_Climbing_Stairs_746 {
    public int minCostClimbingStairs(int[] cost) {
        int p = cost[0], q = cost[1];

        for (int i = 2; i < cost.length; i++) {
            int r = cost[i] + Math.min(p, q);
            p = q;
            q = r;
        }

        return Math.min(p, q);
    }
}
