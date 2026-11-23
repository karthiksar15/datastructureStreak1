import java.util.Arrays;

public class Nov23261 {

    public static void main(String[] args) {
        int[] coins = { 1, 5, 10 };
        int amount = 12;
        Nov23261 nov = new Nov23261();
        System.out.println("coinChange-->" + nov.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amount];
    }

}
