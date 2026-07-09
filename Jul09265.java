import java.util.Arrays;

public class Jul09265 {

    public static void main(String[] args) {
        int amount = 4;
        int[] coins = { 1, 2, 3 };
        Jul09265 jul = new Jul09265();
        System.out.println("change--->" + jul.change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        Arrays.sort(coins);
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    dp[i][j] += dp[i + 1][j] + dp[i][j - coins[i]];
                }
            }
        }
        return dp[0][amount];
    }

}
