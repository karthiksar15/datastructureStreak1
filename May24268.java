import java.util.List;

public class May24268 {

    public static void main(String[] args) {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        May24268 may = new May24268();
        System.out.println("wordbreak--->" + may.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
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
