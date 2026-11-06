import java.util.ArrayList;
import java.util.List;

public class Nov0626 {

    public static void main(String[] args) {
        Nov0626 nov = new Nov0626();
        String digits = "34";
        System.out.println("letter combinations--->" + nov.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        String[] digitToChar = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        if (digits.isEmpty())
            return null;
        backtrack(result, digitToChar, 0, "", digits);
        return result;
    }

    public void backtrack(List<String> result, String[] digitToChar, int index, String curr, String digits) {
        if (curr.length() == digits.length()) {
            result.add(curr);
            return;
        }
        String chars = digitToChar[digits.charAt(index) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(result, digitToChar, index + 1, curr + c, digits);
        }
    }

}
