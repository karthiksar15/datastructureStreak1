public class Jun04263 {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "xyz";
        Jun04263 jun = new Jun04263();
        System.out.println("merge alternatively--->" + jun.mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        StringBuilder sb = new StringBuilder();
        int i = 0, j = 0;
        while (i < m && j < n) {
            sb.append(word1.charAt(i)).append(word2.charAt(j));
            i++;
            j++;
        }
        while (i < m) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (j < n) {
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();

    }

}
