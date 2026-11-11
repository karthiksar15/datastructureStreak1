
import java.util.Arrays;

public class Nov11269 {

    public static void main(String[] args) {
        int[] stoneValue = { 2, 4, 3, 1 };
        Nov11269 nov = new Nov11269();
        System.out.println("stone game--->" + nov.stoneGameIII(stoneValue));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int total = 0;
            for (int j = i; j < Math.min(i + 3, n); j++) {
                total += stoneValue[j];
                dp[i] = Math.max(dp[i], total - dp[j + 1]);
            }
        }
        int rest = dp[0];
        if (rest == 0)
            return "Tie";
        return rest > 0 ? "Alice" : "Bob";
    }

}
