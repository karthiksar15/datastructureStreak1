public class Apr03262 {

    public static void main(String[] args) {
        Apr03262 apr = new Apr03262();
        String word1 = "abc", word2 = "xyz";
        System.out.println("merge--->" + apr.mergeAlternately(word1, word2));
    }

    public String mergeAlternately(String word1, String word2) {

        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            sb.append(word1.charAt(i)).append(word2.charAt(j));
            i++;
            j++;
        }
        while (i < word1.length()) {
            sb.append(word1.charAt(i));
            i++;
        }
        while (j < word2.length()) {
            sb.append(word2.charAt(j));
            j++;
        }
        return sb.toString();
    }

}
