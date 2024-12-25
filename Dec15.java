import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dec15 {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

    }

    public static int lengthOfLongestSubstring(String s) {

        // sol-1
        // int i = 0;
        // int longest = 0;
        // if (s.length() == 1)
        // return 1;
        // while (i < s.length()) {
        // Set<Character> set = new HashSet<>();
        // for (int j = i; j < s.length(); j++) {
        // if (!set.add(s.charAt(j))) {
        // longest = Math.max(longest, set.size());
        // break;
        // }
        // }
        // longest = Math.max(longest, set.size());
        // i++;
        // }
        // return longest;
        // sol-2
        int longest = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            longest = Math.max(longest, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return longest;
    }

}
