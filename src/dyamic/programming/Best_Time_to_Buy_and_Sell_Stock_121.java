package dyamic.programming;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price > minPrice)
                maxProfit = Math.max(maxProfit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }

        return maxProfit;
    }

    public int maxProfit1(int[] prices) {
        int max_ending_here = 0, max_so_far = 0;
        for (int i = 1; i < prices.length; i++) {
            max_ending_here = Math.max(0, max_ending_here + (prices[i] - prices[i - 1]));
            max_so_far = Math.max(max_so_far, max_ending_here);
        }

        return max_so_far;
    }
}
