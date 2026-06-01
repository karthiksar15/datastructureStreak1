import java.util.HashMap;
import java.util.Map;

public class May31265 {

    private Map<String, Integer> dp = new HashMap<>();

    public static void main(String[] args) {
        int[] prices = { 1, 3, 4, 0, 4 };
        May31265 may = new May31265();
        System.out.println("maxProfit--->" + may.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        return dfs(0, true, prices);
    }

    public int dfs(int i, boolean buying, int[] prices) {
        if (i >= prices.length)
            return 0;
        String key = i + "-" + buying;
        if (dp.containsKey(key))
            return dp.get(key);
        int cooldown = dfs(i + 1, buying, prices);
        if (buying) {
            int buy = dfs(i + 1, false, prices) - prices[i];
            dp.put(key, Math.max(buy, cooldown));
        } else {
            int sell = dfs(i + 2, true, prices) + prices[i];
            dp.put(key, Math.max(sell, cooldown));
        }
        return dp.get(key);
    }

}
