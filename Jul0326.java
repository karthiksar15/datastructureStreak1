import java.util.Arrays;

public class Jul0326 {

    public static void main(String[] args) {
        Jul0326 jul = new Jul0326();
        int[] coins = { 1, 5, 10 };
        System.out.println("coin--->" + jul.coinChange(coins, 12));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount);
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
