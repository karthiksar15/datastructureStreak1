import java.util.HashMap;
import java.util.Map;

public class May30269 {

    public static void main(String[] args) {
        String s = "12";
        May30269 may = new May30269();
        System.out.println("num--->" + may.numDecodings(s));
    }

    public int numDecodings(String s) {
        Map<Integer, Integer> sp = new HashMap<>();
        sp.put(s.length(), 1);
        return dfs(s, sp, 0);
    }

    public int dfs(String s, Map<Integer, Integer> dp, int i) {

        if (dp.containsKey(i))
            return dp.get(i);

        if (s.charAt(i) == '0')
            return 0;

        int res = dfs(s, dp, i + 1);
        if (i + 1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
            res += dfs(s, dp, i + 2);
        }
        dp.put(i, res);
        return res;
    }

}
