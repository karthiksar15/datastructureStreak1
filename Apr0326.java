import java.util.Arrays;

public class Apr0326 {

    public static void main(String[] args) {
        char[] s = { 'n', 'e', 'e', 't' };
        Apr0326 apr = new Apr0326();
        apr.reverseString(s);
        System.out.println("after reverse--->" + Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int i = 0, j = s.length - 1;
        while (i <= j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

}
