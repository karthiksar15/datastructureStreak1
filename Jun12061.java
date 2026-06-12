import java.util.Arrays;

public class Jun12061 {

    public static void main(String[] args) {
        int n = 13;
        Jun12061 jun = new Jun12061();
        System.out.println("numSquares--->" + jun.numSquares(n));
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        for (int target = 1; target <= n; target++) {
            for (int s = 1; s * s <= target; s++) {
                dp[target] = Math.min(dp[target], 1 + dp[target - s * s]);
            }
        }
        return dp[n];
    }

}
