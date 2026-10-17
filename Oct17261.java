public class Oct17261 {

    public static void main(String[] args) {
        String word1 = "monkeys", word2 = "money";
        Oct17261 oct = new Oct17261();
        System.out.println("minDistance-->" + oct.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j < n; j++) {
            dp[m][j] = word2.length() - j;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n] = word1.length() - i;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(j) == word2.charAt(i)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }
            }
        }
        return dp[0][0];
    }
}
