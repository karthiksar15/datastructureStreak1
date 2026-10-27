import java.util.ArrayList;
import java.util.List;

public class Oct2726 {

    public static void main(String[] args) {
        int n = 3;
        Oct2726 oct = new Oct2726();
        System.out.println("generateParanthesis--->" + oct.generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, res, stack, n);
        return res;
    }

    public void backtrack(int open, int close, List<String> res, StringBuilder stack, int n) {
        if (open == close && open == n) {
            res.add(stack.toString());
            return;
        }
        if (open < n) {
            stack.append('(');
            backtrack(open + 1, close, res, stack, n);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (close < open) {
            stack.append(')');
            backtrack(open, close + 1, res, stack, n);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

}
