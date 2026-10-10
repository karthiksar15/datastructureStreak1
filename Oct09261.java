public class Oct09261 {

    public static void main(String[] args) {
        Oct09261 oct = new Oct09261();
        System.out.println("climb stairs--->" + oct.climbStairs(3));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
