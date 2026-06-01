public class Jun01262 {

    public static void main(String[] args) {
        String s = "abbadc";
        Jun01262 jun = new Jun01262();
        System.out.println("valid--->" + jun.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return (isPalin(s, i + 1, j) || isPalin(s, i, j - 1));
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalin(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
