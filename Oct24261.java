import java.util.List;

public class Oct24261 {

    public static void main(String[] args) {
        String s = "neetcode";
        List<String> wordDict = List.of("neet", "code");
        Oct24261 oct = new Oct24261();
        System.out.println("wordBreak--->" + oct.wordBreak(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        int m = s.length();
        boolean[] dp = new boolean[m + 1];
        dp[m] = true;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i + wordDict.get(j).length() <= s.length()
                        && wordDict.get(j).equals(s.substring(i, i + wordDict.get(j).length()))) {
                    dp[i] = dp[i + wordDict.get(j).length()];
                }
                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }

}
