public class Apr2826 {

    public static void main(String[] args) {
        Apr2826 apr = new Apr2826();
        int[] prices = { 10, 1, 5, 6, 7, 1 };
        System.out.println("maxProfit---->" + apr.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];
        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(sell, minBuy);
        }
        return maxP;
        // int l = 0, r = 1;
        // int maxProfit = 0;
        // while (r < prices.length) {
        // if (prices[l] < prices[r]) {
        // int profit = prices[r] - prices[l];
        // maxProfit = Math.max(profit, maxProfit);
        // } else {
        // l = r;
        // }
        // r++;
        // }
        // return maxProfit;
    }

}
