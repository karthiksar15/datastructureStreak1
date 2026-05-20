import java.util.Stack;

public class May20261 {

    public static void main(String[] args) {
        May20261 may = new May20261();
        String path = "/neetcode/practice//...///../courses";
        System.out.println("simplify--->" + may.simplifyPath(path));
    }

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] paths = path.split("/");

        for (String p : paths) {
            if (p.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else if (!p.equals("") && (!p.equals("."))) {
                stack.push(p);
            }
        }
        return "/" + String.join("/", stack);
    }

}
