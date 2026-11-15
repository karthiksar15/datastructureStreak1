import java.util.List;

public class Nov15269 {

    public static void main(String[] args) {
        Nov15269 nov = new Nov15269();
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        System.out.println("wordBreak-->" + nov.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        int n = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= n && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }

}
