public class Apr0426 {

    public static void main(String[] args) {
        Apr0426 apr = new Apr0426();
        String s = "abcabc";
        System.out.println("number--->" + apr.numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        int len = s.length();
        int[] trackPos = { -1, -1, -1 };
        int total = 0;
        for (int pos = 0; pos < len; pos++) {
            trackPos[s.charAt(pos) - 'a'] = pos;
            total += 1 + Math.min(trackPos[0], Math.min(trackPos[1], trackPos[2]));
        }
        return total;

    }

}
