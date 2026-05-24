import java.util.HashMap;
import java.util.Map;

public class May24265 {
    Map<Integer, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        May24265 may = new May24265();
        int[] coins = { 1, 5, 10 };
        int amount = 12;
        System.out.println("coin change-->" + may.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int minCoins = dfs(coins, amount);
        return minCoins == Integer.MAX_VALUE ? -1 : minCoins;
    }

    public int dfs(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount - coin >= 0) {
                int result = dfs(coins, amount - coin);
                if (result != Integer.MAX_VALUE) {
                    res = Math.min(res, result + 1);
                }
            }
        }
        memo.put(amount, res);
        return res;
    }

}
