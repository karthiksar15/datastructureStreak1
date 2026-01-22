import java.util.ArrayList;
import java.util.List;

public class Jan2226 {

    public static void main(String[] args) {
        Jan2226 jan = new Jan2226();
        System.out.println("combi---->" + jan.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(1, output, new ArrayList<>(), n, k);
        return output;
    }

    public void backtrack(int num, List<List<Integer>> output, List<Integer> curr, int n, int k) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int i = num; i <= n; i++) {
            curr.add(i);
            backtrack(i + 1, output, curr, n, k);
            curr.remove(curr.size() - 1);
        }
    }

}
