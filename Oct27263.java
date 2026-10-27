import java.util.List;

public class Oct27263 {

    public static void main(String[] args) {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        Oct27263 oct = new Oct27263();
        System.out.println("wordBreak-->" + oct.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[m] = true;
        for (int i = m - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= m && s.substring(i, i + word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }

}
