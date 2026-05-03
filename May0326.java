import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class May0326 {

    public static void main(String[] args) {
        int[] arr = { 2, 4, 5, 8 };
        int k = 2, x = 6;
        May0326 may = new May0326();
        System.out.println("closest elements-->" + may.findClosestElements(arr, k, x));
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> result = new ArrayList<>();
        int idx = 0;
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[idx] - x) > Math.abs(arr[i] - x)) {
                idx = i;
            }
        }
        int l = idx - 1, r = idx + 1, n = arr.length;
        result.add(arr[idx]);
        while (result.size() < k) {
            if (l >= 0 && r < n) {
                if (Math.abs(x - arr[l]) <= Math.abs(x - arr[r])) {
                    result.add(arr[l--]);
                } else {
                    result.add(arr[r++]);
                }
            } else if (l >= 0) {
                result.add(arr[l--]);
            } else if (r < n) {
                result.add(arr[r--]);
            }
        }
        Collections.sort(result);
        return result;
    }

}
