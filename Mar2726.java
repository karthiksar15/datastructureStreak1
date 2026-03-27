public class Mar2726 {

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        Mar2726 mar = new Mar2726();
        System.out.println("max profit--->" + mar.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                count += (prices[i] - prices[i - 1]);
            }
        }
        return count;
    }

}
