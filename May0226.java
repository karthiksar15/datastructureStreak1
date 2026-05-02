public class May0126 {

    public static void main(String[] args) {
        May0126 may = new May0126();
        String s = "XYYXZ";
        int k = 2;
        System.out.println("charac--->" + may.characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int max = 0;
        int maxLength = 0;
        int[] count = new int[26];
        while (r < s.length()) {
            int currentIndex = s.charAt(r) - 'A';
            count[currentIndex]++;
            max = Math.max(max, count[currentIndex]);
            while ((r - l + 1) - max > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }
            maxLength = Math.max(maxLength, (r - l + 1));
            r++;
        }
        return maxLength;
    }

}
