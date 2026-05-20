import java.util.Stack;

public class May20262 {

    public static void main(String[] args) {
        May20262 may = new May20262();
        // String s = "axb3[z]4[c]";
        String s = "2[a3[b]]c";
        System.out.println("decodeString--->" + may.decodeString(s));
    }

    public String decodeString(String s) {
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int k = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                k = k * 10 + (c - '0');
            } else if (c == '[') {
                stringStack.push(sb.toString());
                countStack.push(k);
                sb = new StringBuilder();
                k = 0;
            } else if (c == ']') {
                String temp = sb.toString();
                sb = new StringBuilder(stringStack.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    sb.append(temp);
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
