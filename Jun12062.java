public class Jun12062 {

    public static void main(String[] args) {
        int n = 4;
        Jun12062 jun = new Jun12062();
        System.out.println("integer break-->" + jun.integerBreak(n));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int num = 2; num <= n; num++) {
            dp[num] = (num == n) ? 0 : num;
            for (int i = 1; i < num; i++) {
                dp[num] = Math.max(dp[num], dp[i] * dp[num - 1]);
            }
        }
        return dp[n];
    }

}
