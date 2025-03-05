import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Jan7 {

    public static void main(String[] args) {
        String s = "{([]){}}{{";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> matching = new HashMap<>();
        matching.put('(', ')');
        matching.put('{', '}');
        matching.put('[', ']');
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (matching.get(s.charAt(i)) == null) {
                int j = stack.size() - 1;
                while (j >= 0) {
                    Character letter = stack.get(j);
                    if (matching.containsKey(letter)) {
                        stack.remove(letter);
                        break;
                    }
                    j--;
                }
                if (j < 0) {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;

    }

}

