import java.util.ArrayList;
import java.util.List;

public class Apr22263 {

    public static void main(String[] args) {
        List<Integer> input = List.of(1, 2, 2);
        List<List<Integer>> output = new ArrayList<>();
        Apr22263 apr = new Apr22263();
        apr.backtrack(output, input, new ArrayList<>(), 0);
        System.out.println("subset---" + output);
    }

    public void backtrack(List<List<Integer>> output, List<Integer> input, List<Integer> temp, int index) {
        output.add(new ArrayList<>(temp));
        for (int i = index; i < input.size(); i++) {
            if (i > index && input.get(i) == input.get(i - 1))
                continue;
            temp.add(input.get(i));
            backtrack(output, input, temp, i + 1);
            temp.remove(temp.size() - 1);
        }

    }

}
