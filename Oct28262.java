public class Oct28262 {

    public static void main(String[] args) {
        Oct28262 oct = new Oct28262();
        System.out.println("integerBreak-->" + oct.integerBreak(12));
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
