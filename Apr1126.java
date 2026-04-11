import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Apr1126 {
    public static void main(String[] args) {
        Apr1126 apr = new Apr1126();
        int[] arr = { 1, 2, 3, 4, 5 };
        int k = 4;
        int x = 3;
        System.out.println("findclosest--->" + apr.findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] a) -> a[1]).thenComparingDouble((a) -> a[0]));
        for (int i : arr) {
            pq.add(new int[] { i, Math.abs(x - i) });
        }
        int left = 0;
        List<Integer> result = new ArrayList<>();
        for (int[] num : pq) {
            if (left == k)
                break;
            result.add(num[0]);
            left++;
        }
        Collections.sort(result);
        return result;
    }
}
