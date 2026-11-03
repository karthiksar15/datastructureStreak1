import java.util.ArrayList;
import java.util.List;

public class Nov03261 {

    public static void main(String[] args) {
        Nov03261 nov = new Nov03261();
        String s = "aab";
        System.out.println("partition--->" + nov.partition(s));
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> palin = new ArrayList<>();
        backtrack(result, palin, 0, s);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> palin, int index, String s) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(palin));
            return;
        }
        for (int j = index; j < s.length(); j++) {
            if (isPalin(index, j, s)) {
                palin.add(s.substring(index, j + 1));
                backtrack(result, palin, j + 1, s);
                palin.remove(palin.size() - 1);
            }
        }
    }

    public boolean isPalin(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

}
