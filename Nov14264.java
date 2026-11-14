public class Nov14264 {

    public static void main(String[] args) {
        Nov14264 nov = new Nov14264();
        System.out.println("integerBreak--->" + nov.integerBreak(12));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (i == n) ? 0 : i;
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
            }
        }
        return dp[n];
    }

}
