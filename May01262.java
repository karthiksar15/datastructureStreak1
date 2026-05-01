public class Apr2926 {

    public static void main(String[] args) {
        String s = "pwwkew";
        Apr2926 apr = new Apr2926();
        System.out.println("longestSubstring-->" + apr.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        char[] chr = new char[128];
        int l = 0, r = 0;
        int max = 0;
        while (r < s.length()) {
            char rightChar = s.charAt(r);
            chr[rightChar]++;
            while (chr[s.charAt(r)] > 1) {
                char leftChar = s.charAt(l);
                chr[leftChar]--;
                l++;
            }
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }

}
