import java.util.HashSet;
import java.util.Set;

public class Apr06262 {

    public static void main(String[] args) {
        Apr06262 apr = new Apr06262();
        String s = "aaacb";
        System.out.println("number--->" + apr.numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        int[] freq = new int[3];
        int left = 0;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {

            freq[(s.charAt(right)) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += s.length() - right;
                freq[s.charAt(left) - 'a']--;
                left++;
            }

        }

        return count;
    }

}
