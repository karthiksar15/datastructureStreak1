public class Apr03261 {

    public static void main(String[] args) {
        String s = "zzxyzz";
        Apr03261 apr = new Apr03261();
        System.out.println("valid palindrome--->" + apr.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
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
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
