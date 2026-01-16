import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Jan16261 {

    public static void main(String[] args) {
        String digits = "23";
        Jan16261 jan = new Jan16261();
        System.out.println("combi--->" + jan.letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = Map.of('2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z'));
        List<String> output = new ArrayList<>();
        int target = digits.length();
        StringBuilder sb = new StringBuilder();
        backtrack(map, output, 0, target, sb, digits);
        return output;
    }

    public void backtrack(Map<Character, List<Character>> map, List<String> output, int index, int target,
            StringBuilder curr, String input) {
        if (curr.length() == target) {
            output.add(curr.toString());
            return;
        }
        List<Character> chrLst = map.get(input.charAt(index));
        if (chrLst != null && chrLst.size() > 0) {
            for (Character c : chrLst) {
                curr.append(c);
                backtrack(map, output, index + 1, target, curr, input);
                curr.deleteCharAt(curr.length() - 1);
            }
        }
    }

}
