import java.util.Arrays;

public class Jun08261 {

    public static void main(String[] args) {
        int[] coins = { 5, 3, 10 };
        int amount = 13;
        Jun08261 jun = new Jun08261();
        System.out.println("coinChange--->" + jun.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
