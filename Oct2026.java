import java.util.ArrayList;
import java.util.List;

public class Oct2026 {

    public static void main(String[] args) {
        int n = 3, k = 2;
        Oct2026 oct = new Oct2026();
        System.out.println("combine--->" + oct.combine(n, k));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(n, k, result, new ArrayList<>(), 1);
        return result;
    }

    public void backtrack(int n, int k, List<List<Integer>> result, List<Integer> subset, int index) {
        if (index > n) {
            if (subset.size() == k) {
                result.add(new ArrayList<>(subset));
            }
            return;
        }
        subset.add(index);
        backtrack(n, k, result, subset, index + 1);
        subset.remove(subset.size() - 1);
        backtrack(n, k, result, subset, index + 1);
    }

}
