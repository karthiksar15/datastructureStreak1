import java.util.ArrayList;
import java.util.List;

public class Nov03262 {

    public static void main(String[] args) {
        Nov03262 nov = new Nov03262();
        String s = "aab";
        System.out.println("partition--->" + nov.partition(s));
    }

    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n + 1][n + 1];
        List<List<String>> result = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            List<String> pal = new ArrayList<>();
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                }
            }
        }
        return result;
    }

}
