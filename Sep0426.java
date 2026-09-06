public class Sep0426 {

    public static void main(String[] args) {
        String word1 = "monk";
        String word2 = "mon";
        Sep0426 sep = new Sep0426();
        System.out.println("minDistance--->" + sep.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int j = 0; j < word2.length(); j++) {
            dp[word1.length()][j] = word2.length() - j;
        }
        for (int i = 0; i < word1.length(); i++) {
            dp[i][word2.length()] = word1.length() - i;
        }

        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
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

// o/p:
// +---------+-----+-----+-----+-----+
// | Index | 0 | 1 | 2 | 3 |
// +---------+-----+-----+-----+-----+
// | Row 0 | 1 | 2 | 3 | 4 |
// | Row 1 | 2 | 1 | 2 | 3 |
// | Row 2 | 3 | 2 | 1 | 2 |
// | Row 3 | 3 | 2 | 1 | 1 |
// | Row 4 | 3 | 2 | 1 | 0 |
// +---------+-----+-----+-----+-----+