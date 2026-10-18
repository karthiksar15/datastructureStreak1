
import java.util.Arrays;

public class Oct182617 {

    public static void main(String[] args) {
        Oct182617 oct = new Oct182617();
        System.out.println("numSquares--->" + oct.numSquares(13));
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
