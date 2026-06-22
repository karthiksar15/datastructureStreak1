import java.util.Arrays;

class Jun2026 {
    public static void main(String[] args) {
        Jun2026 jun = new Jun2026();
        int[] stoneValue = { 2, 4, 3, 1 };
        System.out.println("stone game--->" + jun.stoneGameIII(stoneValue));
    }

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int total = 0;
            for (int j = i; j < Math.min(i + 3, n); j++) {
                total += stoneValue[j];
                dp[i] = Math.max(dp[i], total - dp[j + 1]);
            }
        }
        int result = dp[0];
        if (result == 0)
            return "Tie";
        return result > 0 ? "Alice" : "Bob";
    }

}
