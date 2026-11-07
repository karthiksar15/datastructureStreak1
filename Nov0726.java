import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Nov0726 {

    public static void main(String[] args) {
        Nov0726 nov = new Nov0726();
        String digits = "34";
        System.out.println("letter combinations--->" + nov.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuvw");
        map.put('9', "xyz");
        List<String> res = new ArrayList<>();
        backtrack(digits, map, 0, res, new StringBuilder());
        return res;
    }

    public void backtrack(String digits, Map<Character, String> map, int index, List<String> res, StringBuilder sb) {
        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }
        char currChar = digits.charAt(index);
        String currStr = map.get(currChar);
        for (int i = 0; i < currStr.length(); i++) {
            sb.append(currStr.charAt(i));
            backtrack(digits, map, index + 1, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
