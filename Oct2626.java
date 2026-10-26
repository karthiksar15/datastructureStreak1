public class Oct2626 {

    public static void main(String[] args) {
        Oct2626 oct = new Oct2626();
        System.out.println("climbStairs--->" + oct.climbStairs(5));
    }

    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

}
