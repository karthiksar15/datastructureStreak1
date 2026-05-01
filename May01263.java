import java.util.HashMap;
import java.util.Map;

public class Apr3026 {

    public static void main(String[] args) {
        Apr3026 apr = new Apr3026();
        String s = "XYYX";
        int k = 2;
        System.out.println("charac--->" + apr.characterReplacement(s, k));
    }

    public int characterReplacement(String s, int k) {
        int[] counts = new int[26];
        int left = 0;
        int maxFrequency = 0;
        int maxLength = 0;
        for (int right = 0; right < s.length(); right++) {
            int currentIndex = s.charAt(right) - 'A';
            counts[currentIndex]++;
            maxFrequency = Math.max(maxFrequency, counts[currentIndex]);
            while ((right - left + 1) - maxFrequency > k) {
                counts[s.charAt(left) - 'A']--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
