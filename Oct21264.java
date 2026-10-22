import java.util.*;

public class Oct21264 {

    public static void main(String[] args) {
        int[] stoneValues = { 2, 4, 3, 1 };
        Oct21264 oct = new Oct21264();
        System.out.println("stoneGame--->" + oct.stoneGameIII(stoneValues));

    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;
        for (int i = 0; i < n; i++) {
            int tot = 0;
            for (int j = i; j < Math.min(i + 3, n); j++) {
                tot += stoneValue[i];
                dp[i] = Math.max(dp[i], tot - dp[j + 1]);
            }
        }
        int result = dp[0];
        if (result == 0)
            return "Tie";
        return result > 0 ? "Alice" : "Bob";
    }

}
