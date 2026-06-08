import java.util.HashMap;
import java.util.Map;

public class Jun0826 {

    public static void main(String[] args) {
        String s = "12";
        Jun0826 jun = new Jun0826();
        System.out.println("num--->" + jun.numDecodings(s));
    }

    public int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i + 1];
                if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    dp[i] += dp[i + 2];
                }
            }
        }
        return dp[0];
    }

}
