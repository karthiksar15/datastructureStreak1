public class Oct1026 {

    public static void main(String[] args) {
        int n = 21;
        Oct1026 oct = new Oct1026();
        System.out.println("tribon--->" + oct.tribonacci(n));
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
