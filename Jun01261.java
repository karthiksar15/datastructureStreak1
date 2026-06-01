public class Jun01261 {

    public static void main(String[] args) {
        String s = "Was it a car or a cat I saw?";
        Jun01261 jun = new Jun01261();
        System.out.println("isPalindrome-->" + jun.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit((s.charAt(i)))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            j--;
            i++;
        }
        return true;
    }

}
