import java.util.HashMap;
import java.util.Map;

public class Mar0126 {

    public static void main(String[] args) {
        String s = "racecar", t = "carrace";
        Mar0126 ma = new Mar0126();
        System.out.println("is it-->" + ma.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (t.length() != s.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int v : map.values()) {
            if (v != 0)
                return false;
        }
        return true;
    }

}
