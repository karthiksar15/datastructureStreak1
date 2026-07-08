import java.util.Arrays;

public class Jul0726 {

    public static void main(String[] args) {
        Jul0726 jul = new Jul0726();
        int[] stoneValue = { 2, 4, 3, 1 };
        System.out.println("stonegame--->" + jul.stoneGameIII(stoneValue));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[n] = 0;
        int total = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < Math.min(i + 3, n); j++) {
                total += stoneValue[j];
                dp[i] = Math.max(total - dp[j + 1], dp[i]);
            }
        }
        int result = dp[0];
        if (result == 0)
            return "Tie";
        return result > 0 ? "Alice" : "Bob";
    }

}
