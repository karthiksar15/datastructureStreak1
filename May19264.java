import java.util.Stack;

public class May19264 {

    private Stack<int[]> stack;

    public May19264() {
        stack = new Stack<>();
    }

    public static void main(String[] args) {
        May19264 may = new May19264();

        System.out.println("may1926--->" + may.next(0));
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[] { price, span });
        return span;
    }

}
