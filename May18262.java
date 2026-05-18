import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class May18262 {

    public static void main(String[] args) {
        String ops = "([{}])";
        May18262 may = new May18262();
        System.out.println("isValid--->" + may.isValid(ops));
    }

    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Stack stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
