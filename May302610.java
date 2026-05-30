import java.util.HashMap;
import java.util.Map;

public class May302610 {

    Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        int[] coins = { 1, 5, 10 };
        int amount = 12;
        May302610 may = new May302610();
        System.out.println("coin changee---->" + may.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int min = dfs(coins, amount);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public int dfs(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (memo.containsKey(amount))
            return memo.get(amount);
        int res = Integer.MAX_VALUE;
        for (int cn : coins) {
            int diff = amount - cn;
            if (diff >= 0) {
                int result = dfs(coins, diff);
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(result + 1, res);
                }
            }
        }
        memo.put(amount, res);
        return res;
    }

}
