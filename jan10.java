import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Jan12 {

    public static void main(String[] args) {

        StockSpanner sp = new StockSpanner();
        int[] stocks = { 100, 80, 60, 70, 60, 75, 85 };
        for (int num : stocks) {
            int result = sp.next(num);
            System.out.println(result);
        }

    }

}

class StockSpanner {

    Stack<int[]> stack = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            ans += stack.pop()[1];
        }

        stack.push(new int[] { price, ans });
        return ans;

    }
}

