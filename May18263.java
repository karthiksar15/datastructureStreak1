import java.util.Stack;

public class May18263 {

    public static void main(String[] args) {

    }

}

class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = val;
        } else {
            stack.push(val - min);
            min = Math.min(min, val);
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        long val = stack.pop();
        if (val < 0)
            min = min - val;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0)
            return (int) (top + min);
        else
            return (int) min;
    }

    public int getMin() {
        return (int) min;
    }
}
