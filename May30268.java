public class May30268 {

    public static void main(String[] args) {
        String s = "abc";
        May30268 may = new May30268();
        System.out.println("count-->" + may.countSubstrings(s));
    }

    public int countSubstrings(String s) {
        int cnt = 0;
        boolean[][] flag = new boolean[s.length()][s.length()];
        for (int j = s.length() - 1; j >= 0; j--) {
            for (int i = j; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i <= 2 || flag[i][j])) {
                    flag[i][j] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
