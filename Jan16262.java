import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Jan16262 {
    Set<String> duplicated = new HashSet<>();

    public static void main(String[] args) {
        Jan16262 jan = new Jan16262();
        int[] candidates = { 2, 3, 6, 7 };
        int target = 7;
        System.out.println("combi--->" + jan.combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(candidates, target, output, new ArrayList<>(), 0);
        return output;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> output, List<Integer> currList,
            int currSum) {
        if (currSum == target) {
            String s = currList.stream().sorted().map(String::valueOf).collect(Collectors.joining());
            if (!duplicated.contains(s)) {
                duplicated.add(s);
                output.add(new ArrayList<>(currList));
            }
            return;
        }
        if (currSum > target) {
            return;
        }
        for (int can : candidates) {
            currSum += can;
            currList.add(can);
            backtrack(candidates, target, output, currList, currSum);
            int temp = currList.remove(currList.size() - 1);
            currSum -= temp;
        }
    }

}
