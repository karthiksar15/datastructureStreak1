import java.util.ArrayList;
import java.util.List;

public class Jan15262 {

    public static void main(String[] args) {
        int n = 4, k = 2;
        Jan15262 jan = new Jan15262();
        System.out.println("combination---->" + jan.combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(new ArrayList<>(), 1, output, n, k);
        return output;
    }

    public void backtrack(List<Integer> curr, int index, List<List<Integer>> output, int n, int k) {
        if (curr.size() == k) {
            output.add(new ArrayList<>(curr));
            return;
        }
        for (int i = index; i <= n; i++) {
            if (!curr.contains(i)) {
                curr.add(i);
                backtrack(curr, i + 1, output, n, k);
                curr.remove(curr.size() - 1);
            }
        }
    }

}
