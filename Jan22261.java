import java.util.ArrayList;
import java.util.List;

public class Jan22261 {
    public static void main(String[] args) {
        Jan22261 jan = new Jan22261();
        System.out.println("combi sum--->" + jan.combinationSum3(2, 18));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(1, output, new ArrayList<>(), k, n, 0);
        return output;
    }

    public void backtrack(int num, List<List<Integer>> output, List<Integer> curr, int k, int n, int sum) {

        if (num > 10)
            return;

        if (curr.size() == k && sum == n) {
            output.add(new ArrayList<>(curr));
            return;
        }
        if (curr.size() == k || sum > n) {
            return;
        }
        // if (curr.size() == k) {
        // return;
        // }

        for (int i = num; i <= n; i++) {
            curr.add(i);
            sum += i;
            backtrack(i + 1, output, curr, k, n, sum);
            int removed = curr.remove(curr.size() - 1);
            sum -= removed;
        }
    }
}
