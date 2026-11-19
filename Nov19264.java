import java.util.List;

public class Nov19264 {

    public static void main(String[] args) {
        Nov19264 nov = new Nov19264();
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        System.out.println("wordBreak-->" + nov.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;
        for (int i = n - 1; i >= 0; i--) {
            for (String w : wordDict) {
                if (i + w.length() <= s.length() && s.substring(i, i + w.length()).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }
            }
        }
        return dp[0];
    }

}
