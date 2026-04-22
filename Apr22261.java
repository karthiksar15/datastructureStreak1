import java.util.ArrayList;
import java.util.List;

public class Apr22261 {

    public static void main(String[] args) {
        Apr22261 apr = new Apr22261();
        List<Integer> input = List.of(1, 2, 3);
        List<List<Integer>> output = new ArrayList<>();
        apr.subset(0, output, input, new ArrayList<>());
        System.out.println("subsets-->" + output);
    }

    public void subset(int index, List<List<Integer>> output, List<Integer> input, List<Integer> temp) {
        if (index == input.size()) {
            output.add(new ArrayList<>(temp));
            return;
        }
        temp.add(input.get(index));
        subset(index + 1, output, input, temp);
        temp.remove(temp.size() - 1);
        subset(index + 1, output, input, temp);
    }

}
