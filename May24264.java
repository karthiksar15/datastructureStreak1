import java.util.HashMap;
import java.util.Map;

public class May24264 {

    public static void main(String[] args) {
        May24264 may = new May24264();
        String s = "12";
        System.out.println("numDecodings--->" + may.numDecodings(s));
    }

    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 1);
        return dfs(s, 0, dp);
    }

    public int dfs(String s, int i, Map<Integer, Integer> dp) {
        if (dp.containsKey(i)) {
            return dp.get(i);
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        int res = dfs(s, i + 1, dp);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(s, i + 2, dp);
        }
        dp.put(i, res);
        return res;
    }

}
