import java.util.Deque;
import java.util.LinkedList;

public class Jan29262 {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
        int start = 5;
        Jan29262 jan = new Jan29262();
        System.out.println("canReach--->" + jan.canReach(arr, start));
    }

    public boolean canReach(int[] arr, int start) {

        boolean[] visited = new boolean[arr.length];
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int[] steps = { 1, -1 };
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (arr[temp] == 0)
                return true;
            int val = arr[temp];
            int plus = temp + (steps[0] * val);
            int minus = temp + (steps[1] * val);
            if (plus < arr.length && plus > 0 && !visited[plus]) {
                queue.add(plus);
                visited[plus] = true;
            }
            if (minus < arr.length && minus > 0 && !visited[minus]) {
                queue.add(minus);
                visited[minus] = true;
            }

        }
        return false;
    }

}
