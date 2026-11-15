
import java.util.Arrays;

public class Nov15265 {

    public static void main(String[] args) {
        Nov15265 nov = new Nov15265();
        System.out.println("numSquares-->" + nov.numSquares(13));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - (j * j)]);
            }
        }
        return dp[n];
    }

}
