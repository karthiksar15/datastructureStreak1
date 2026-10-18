
import java.util.Arrays;

public class Oct182610 {

    public static void main(String[] args) {
        int[] coins = { 1, 5, 10 };
        int amount = 12;
        Oct182610 oct = new Oct182610();
        System.out.println("coinChange--->" + oct.coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (c <= i) {
                    dp[i] = Math.min(dp[i - c] + 1, dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
