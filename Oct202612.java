public class Oct202612 {

    public static void main(String[] args) {
        String word1 = "monkeys", word2 = "money";
        Oct202612 oct = new Oct202612();
        System.out.println("minDistance-->" + oct.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 0; j < n; j++) {
            dp[m][j] = n - j;
        }
        for (int i = 0; i < m; i++) {
            dp[i][n] = m - i;
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j], Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
                }

            }
        }
        return dp[0][0];
    }

}
