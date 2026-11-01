import java.util.*;

public class Nov0126 {

    public static void main(String[] args) {
        Nov0126 nov = new Nov0126();
        int[] stoneValue = { 1, 2, 1, 5 };
        System.out.println("stonegame--->" + nov.stoneGameIII(stoneValue));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int tot = 0;
            for (int j = i; j < Math.min(i + 3, n); j++) {
                tot += stoneValue[j];
                dp[i] = Math.max(dp[i], tot - dp[i + 1]);
            }
        }
        if (dp[0] == 0)
            return "Tie";
        return dp[0] > 0 ? "Alice" : "Bob";
    }

}
