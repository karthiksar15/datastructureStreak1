import java.util.ArrayList;
import java.util.List;

public class Nov0326 {

    public static void main(String[] args) {
        Nov0326 nov = new Nov0326();
        String s = "aab";
        System.out.println("partition--->" + nov.partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> subset = new ArrayList<>();
        backtrack(result, subset, 0, 0, s);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> subset, int i, int j, String s) {
        if (j >= s.length()) {
            if (i == j) {
                result.add(new ArrayList<>(subset));
            }
            return;
        }
        if (isPali(i, j, s)) {
            subset.add(s.substring(i, j + 1));
            backtrack(result, subset, j + 1, j + 1, s);
            subset.remove(subset.size() - 1);
        }
        backtrack(result, subset, i, j + 1, s);
    }

    public boolean isPali(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
