public class Jun22261 {

    public static void main(String[] args) {
        Jun22261 jun = new Jun22261();
        int n = 21;
        System.out.println("trib--->" + jun.tribonacci(n));
    }

    public int tribonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

}
