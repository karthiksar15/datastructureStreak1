import java.util.List;

public class Jul0526 {

    public static void main(String[] args) {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        Jul0526 jul = new Jul0526();
        System.out.println("wordBreak--->" + jul.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (String str : wordDict) {
                if (i + str.length() <= s.length() && s.substring(i, i + str.length()).equals(str)) {
                    dp[i] = dp[i + str.length()];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }

}
