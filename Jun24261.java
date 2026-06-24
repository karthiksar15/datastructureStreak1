import java.util.Arrays;

public class Jun24261 {

    public static void main(String[] args) {
        Jun24261 jun = new Jun24261();
        int[] coins = { 1, 5, 10 };
        int target = 12;
        System.out.println("coin change-->" + jun.coinChange(coins, target));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int n : coins) {
                if (n <= i) {
                    dp[i] = Math.min(dp[i], dp[i - n] + 1);
                }
            }
        }
        return dp[amount] > amount + 1 ? -1 : dp[amount];
    }

}
