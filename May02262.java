public class May02261 {

    public static void main(String[] args) {
        May02261 may = new May02261();
        // s1="abc"
        // s2="lecaabee"
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println("check inclusion--->" + may.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length())
            return false;
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1Count, s2Count))
                return true;
            s2Count[s2.charAt(i + s1.length())]++;
            s2Count[s2.charAt(i)]--;
        }
        return false;
    }

    public boolean matches(int[] s1, int[] s2) {
        for (int i = 0; i < 26; i++) {
            if (s1[i] != s2[i])
                return false;
        }
        return true;
    }

}
