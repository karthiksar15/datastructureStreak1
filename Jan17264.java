import java.util.ArrayList;
import java.util.List;

public class Jan17264 {

    public static void main(String[] args) {
        Jan17264 jan = new Jan17264();
        System.out.println("generateParenthesis--->" + jan.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        backtrack(n, output, new StringBuilder(), 0, 0);
        return output;
    }

    public void backtrack(int n, List<String> output, StringBuilder temp, int leftCount, int rightCount) {
        if (2 * n == temp.length()) {
            output.add(temp.toString());
            return;
        }
        if (leftCount < n) {
            backtrack(n, output, temp.append("("), leftCount + 1, rightCount);
            temp.deleteCharAt(temp.length() - 1);
        }
        if (leftCount > rightCount) {
            backtrack(n, output, temp.append(")"), leftCount, rightCount + 1);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

}
