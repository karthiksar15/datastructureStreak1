import java.util.Arrays;

public class May31263 {

    int[][] dp;

    public static void main(String[] args) {
        String text1 = "cat";
        String text2 = "crabt";
        May31263 may = new May31263();
        System.out.println("longest--->" + may.longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(text1, text2, 0, 0, m, n);
    }

    public int dfs(String text1, String text2, int i, int j, int m, int n) {
        if (i == m || j == n) {
            return 0;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + dfs(text1, text2, i + 1, j + 1, m, n);
        } else {
            dp[i][j] = Math.max(dfs(text1, text2, i + 1, j, m, n), dfs(text1, text2, i, j + 1, m, n));
        }
        return dp[i][j];
    }

}
