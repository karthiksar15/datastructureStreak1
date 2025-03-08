import java.nio.channels.NetworkChannel;
import java.util.Stack;

public class Jan9 {

    public static void main(String[] args) {
        String s = "leEeetcode";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (Character ctr : s.toCharArray()) {
            // System.out.println("ctr--" + ctr + "---number" + (ctr + 0));
            // if (!stack.isEmpty())
            // System.out.println("st--" + stack.peek() + "--number--" + (stack.peek() -
            // 32));

            if ((!stack.isEmpty()) && (((ctr) == stack.peek() - 32) || ((ctr - 32) == stack.peek()))) {
                stack.pop();
            } else {
                stack.push(ctr);

            }
        }
        for (Character c : stack) {
            builder.append(c);
        }
        return builder.toString();
    }

}

