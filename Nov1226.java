public class Nov1226 {

    public static void main(String[] args) {
        Nov1226 nov = new Nov1226();
        System.out.println("climb Stairs--->" + nov.climbStairs(3));
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
