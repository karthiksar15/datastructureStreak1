import java.util.ArrayList;
import java.util.List;

public class Apr22262 {

    public static void main(String[] args) {
        Apr22262 apr = new Apr22262();
        int a = 4, b = 2;
        List<List<Integer>> output = new ArrayList<>();
        apr.permutation(output, new ArrayList<>(), a, b, 1);
        System.out.println("permu---" + output);
    }

    public void permutation(List<List<Integer>> output, List<Integer> temp, int a, int b,
            int start) {
        if (temp.size() == b) {
            output.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= a; i++) {
            // if (visited[i])
            // continue;
            temp.add(i);
            // visited[i] = true;
            permutation(output, temp, a, b, i + 1);
            // visited[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}
