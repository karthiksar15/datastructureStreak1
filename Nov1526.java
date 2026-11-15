import java.util.Arrays;

public class Nov1526 {

    public static void main(String[] args) {
        int[] stoneValue = { 2, 4, 3, 1 };
        Nov1526 nov = new Nov1526();
        System.out.println("stone game--->" + nov.stoneGameIII(stoneValue));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;
        for (int i = n; i >= 0; i--) {
            int tot = 0;
            for (int j = i; j < Math.min(i + 3, n); j++) {
                tot += stoneValue[j];
                dp[i] = Math.max(dp[i], tot - dp[j + 1]);
            }
        }
        int result = dp[0];
        if (result == 0)
            return "tie";
        return result > 0 ? "Alicw" : "pei";
    }

}
