import java.util.*;

public class Oct27261 {

    public static void main(String[] args) {
        int[] coins = { 1, 5, 10 };
        int amount = 12;
        Oct27261 oct = new Oct27261();
        System.out.println("coinChange-->" + oct.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i - coins[j]] + 1, dp[i]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

}
