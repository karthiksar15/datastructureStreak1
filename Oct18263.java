public class Oct18263 {

    public static void main(String[] args) {
        Oct18263 oct = new Oct18263();
        System.out.println("trib-->" + oct.tribonacci(21));
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
