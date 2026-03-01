import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mar01263 {

    public static void main(String[] args) {
        Mar01263 mar = new Mar01263();
        String[] strs = { "act", "pots", "tops", "cat", "stop", "hat" };
        System.out.println("anagrams--->" + mar.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(count[i]).append("#");
            }
            map.computeIfAbsent(sb.toString(), v -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

}
