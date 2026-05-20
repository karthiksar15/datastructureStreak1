import java.util.Arrays;
import java.util.Stack;

public class May2026 {

    public static void main(String[] args) {
        May2026 may = new May2026();
        int target = 10;
        int[] position = { 1, 4 };
        int[] speed = { 3, 2 };
        System.out.println("car fleet---->" + may.carFleet(target, position, speed));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 && stack.peek() <= stack.get(stack.size() - 2)) {
                stack.pop();
            }
        }
        return stack.size();
    }

}
