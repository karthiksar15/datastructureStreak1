import java.util.Arrays;

public class Nov14265 {

    public static void main(String[] args) {
        Nov14265 nov = new Nov14265();
        System.out.println("numSquares--->" + nov.numSquares(3));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - (j * j)] + 1);
            }
        }
        return dp[n];
    }

}
