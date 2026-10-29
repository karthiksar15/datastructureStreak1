
import java.util.Arrays;

public class Oct2926 {

    public static void main(String[] args) {
        int[] stoneValue = { 2, 4, 3, 1 };
        Oct2926 oct = new Oct2926();
        System.out.println("stone game--->" + oct.stoneGameIII(stoneValue));
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
                dp[i] = Math.max(dp[i], tot - dp[j + 1]);
            }
        }
        int res = dp[0];
        if (res == 0)
            return "Tie";
        return res > 0 ? "Alice" : "Bob";
    }

}
