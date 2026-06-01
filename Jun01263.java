public class Jun01263 {

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "xyz";
        Jun01263 jun = new Jun01263();
        System.out.println("merge--->" + jun.mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        int m = word1.length(), n = word2.length();
        while (i < m && j < n) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));
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
