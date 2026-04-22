import java.util.ArrayList;
import java.util.List;

public class Apr2226 {

    public static void main(String[] args) {
        Apr2226 apr = new Apr2226();
        List<Integer> input = List.of(1, 2, 3);
        List<List<Integer>> output = new ArrayList<>();
        apr.backtrack(output, input, new ArrayList<>(), new boolean[input.size()]);
        System.out.println("permutation--->" + output);
    }

    public void backtrack(List<List<Integer>> output, List<Integer> input, List<Integer> temp, boolean[] visited) {
        if (temp.size() == input.size()) {
            output.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < input.size(); i++) {
            if (visited[i])
                continue;
            temp.add(input.get(i));
            visited[i] = true;
            backtrack(output, input, temp, visited);
            visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}
