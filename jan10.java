import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Jan12 {

    public static void main(String[] args) {

        StockSpanner sp = new StockSpanner();
        int[] stocks = { 90, 21, 21, 68 };
        for (int num : stocks) {
            int result = sp.next(num);
            System.out.println(result);
        }

    }

}

class StockSpanner {

    Stack<Integer> stack = new Stack<>();

    public StockSpanner() {
    }

    public int next(int price) {

        // recomend
        // int ans = 1;
        // while (!stack.isEmpty() && stack.peek()[0] <= price) {
        // ans += stack.pop()[1];
        // }

        // stack.push(new int[] { price, ans });
        // return ans;

        // my soln
        int count = 1;
        if (!stack.isEmpty() && stack.peek() < price) {
            for (int i = stack.size() - 1; i >= 0; i--) {
                if (stack.get(i) > price)
                    break;
                count++;
            }
        }
        stack.push(price);
        return count;
    }
}
