import java.util.LinkedList;
import java.util.Queue;

class Jan0826 {
    public static void main(String[] args) {
        Jan0826 jan = new Jan0826();
        // int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
        int[] arr = { 3, 0, 2, 1, 2 };
        System.out.println("canREach---" + jan.canReach(arr, 2));
    }

    public boolean canReach(int[] arr, int start) {
        int target = 0;
        int[] change = { -1, 1 };
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        while (!queue.isEmpty()) {
            Integer temp = queue.poll();
            if (arr[temp] == target)
                return true;
            for (int i : change) {
                int newIndex = Math.abs(temp + (i * arr[temp]));
                if (newIndex >= 0 && newIndex < arr.length && newIndex != start) {
                    queue.add(newIndex);
                } else if (newIndex == start) {
                    return false;
                }
            }
        }
        return false;
    }

}
