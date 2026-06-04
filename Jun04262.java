public class Jun04262 {

    public static void main(String[] args) {
        String s = "abbadc";
        Jun04262 jun = new Jun04262();
        System.out.println("valid--->" + jun.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (!(isValid(s, i + 1, j) || isValid(s, i, j - 1))) {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isValid(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
