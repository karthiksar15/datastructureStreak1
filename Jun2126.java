public class Jun2126 {
    public static void main(String[] args) {
        int n = 3;
        Jun2126 jun = new Jun2126();
        System.out.println("climbStairs--->" + jun.climbStairs(n));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
