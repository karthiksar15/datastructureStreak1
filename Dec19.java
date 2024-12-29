import java.util.Map;

public class Dec19 {

    public static void main(String[] args) {
        String roman = "III";
        System.out.println(romanToNumber(roman));
    }

    private static int romanToNumber(String s) {
        Map<String, Integer> map = Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int nextIndex = i + 1;
            if (nextIndex <= s.length() - 1) {
                int firstDigit = map.get(String.valueOf(s.charAt(i)));
                int secondDigit = map.get(String.valueOf(s.charAt(nextIndex)));
                if (firstDigit >= secondDigit) {
                    sum = sum + firstDigit;
                } else {
                    sum = sum - firstDigit;
                }
            } else {
                sum = sum + map.get(String.valueOf(s.charAt(i)));
                break;
            }

        }
        return sum;
    }

}
