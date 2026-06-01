import java.util.Arrays;

public class Jun0126 {

    public static void main(String[] args) {
        char[] s = { 'n', 'e', 'e', 't' };
        Jun0126 jun = new Jun0126();
        jun.reverseString(s);
        System.out.println("reverse--->" + Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
    }

}
