import java.util.HashMap;
import java.util.Map;

public class Apr0926 {

    public static void main(String[] args) {
        Apr0926 apr = new Apr0926();
        String s = "OUZODYXAZV", t = "XYZ";
        System.out.println("min window--->" + apr.minWindow(s, t));
    }

    public String minWindow(String s, String t) {
        String result = "";
        Map<Character, Integer> resultMap = new HashMap<>();
        Map<Character, Integer> compareMap = new HashMap<>();
        for (Character c : t.toCharArray()) {
            compareMap.merge(c, 1, Integer::sum);
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int count = 0;

        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            resultMap.merge(c, 1, Integer::sum);
            // Only increment count when frequency exactly matches
            if (compareMap.containsKey(c) && compareMap.get(c).equals(resultMap.get(c))) {
                count++;
            }

            // Shrink window as long as all chars of t are covered
            while (compareMap.size() == count) {
                if ((right - left + 1) < min) {
                    result = s.substring(left, right + 1);
                    min = right - left + 1;
                }

                char leftChar = s.charAt(left);
                resultMap.merge(leftChar, -1, Integer::sum);

                // Only decrement count if this char was contributing to coverage
                if (compareMap.containsKey(leftChar) &&
                        resultMap.get(leftChar) < compareMap.get(leftChar)) {
                    count--;
                }
                left++;
            }
        }

        return result;
    }

}
