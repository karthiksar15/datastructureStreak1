import java.util.List;

public class Oct182612 {

    public static void main(String[] args) {
        Oct182612 oct = new Oct182612();
        String s = "neetcode";
        List<String> wordDict = List.of("neet");
        System.out.println("wordBreak-->" + oct.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if ((i + w.length()) <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }

}
