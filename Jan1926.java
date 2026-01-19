import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Jan1926 {

    public static void main(String[] args) {
        Jan1926 jan = new Jan1926();
        int k = 3, n = 9;
        System.out.println("combi--->" + jan.combinationSum3(k, n));
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        this.backtrack(n, k, comb, 0, output);
        return output;
    }

    public void backtrack(int n, int k, LinkedList<Integer> list, int nextStart, List<List<Integer>> results) {
        if (n == 0 && list.size() == k) {
            results.add(new ArrayList<>(list));
            return;
        } else if (n < 0 || list.size() == k) {
            return;
        }
        for (int i = nextStart; i < 9; i++) {
            list.add(i + 1);
            this.backtrack(n - (i + 1), k, list, i + 1, results);
            list.removeLast();
        }
    }

}
