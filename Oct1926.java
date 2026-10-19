import java.util.*;

public class Oct1926 {

    public static void main(String[] args) {
        int[] candidates = { 9, 2, 2, 4, 6, 1, 5 };
        int target = 8;
        Oct1926 oct = new Oct1926();
        System.out.println("combination--->" + oct.combinationSum2(candidates, target));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates, target, 0, 0, res, new ArrayList<>());
        return res;
    }

    public void backtrack(int[] candidates, int target, int i, int sum, List<List<Integer>> res, List<Integer> subset) {
        if (sum == target) {
            res.add(new ArrayList<>(subset));
            return;
        }
        if (sum > target || i == candidates.length) {
            return;
        }
        subset.add(candidates[i]);
        backtrack(candidates, target, i + 1, sum + candidates[i], res, subset);
        subset.remove(subset.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        backtrack(candidates, target, i + 1, sum, res, subset);
    }

}
