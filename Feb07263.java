import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Feb07263 {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
        int start = 5;
        Feb07263 feb = new Feb07263();
        System.out.println("canREeach--->" + feb.canReach(arr, start));
    }

    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0)
            return true;
        Deque<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        while (!queue.isEmpty()) {
            int temp = queue.poll();
            if (arr[temp] == 0)
                return true;
            for (int i : List.of(1, -1)) {
                int newNum = temp + (i * arr[temp]);

                if (newNum >= 0 && newNum < arr.length && visited.add(newNum)) {
                    queue.add(newNum);
                }
            }
        }
        return false;
    }

}
