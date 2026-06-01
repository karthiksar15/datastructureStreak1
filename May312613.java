import java.util.Arrays;

public class May312613 {

    int[][] dp;

    public static void main(String[] args) {
        String word1 = "monkeys";
        String word2 = "money";
        May312613 may = new May312613();
        System.out.println("minDistance-->" + may.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m][n];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        return dfs(0, 0, word1, word2, m, n);
    }

    public int dfs(int i, int j, String word1, String word2, int m, int n) {
        if (i == m)
            return n - j;
        if (j == n)
            return m - 1;
        if (dp[i][j] != -1)
            return dp[i][j];
        if (word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = dfs(i + 1, j + 1, word1, word2, m, n);
        } else {
            int res = Math.min(dfs(i + 1, j, word1, word2, m, n), dfs(i, j + 1, word1, word2, m, n));
            res = Math.min(res, dfs(i + 1, j + 1, word1, word2, m, n));
            dp[i][j] = res + 1;
        }
        return dp[i][j];
    }

}
