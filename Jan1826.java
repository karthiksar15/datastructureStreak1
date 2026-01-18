import java.util.ArrayList;
import java.util.List;

public class Jan1826 {

    public static void main(String[] args) {
        Jan1826 jan = new Jan1826();
        System.out.println("consec---->" + jan.numsSameConsecDiff(3, 7));
    }

    public int[] numsSameConsecDiff(int n, int k) {
        if (n == 1) {
            return new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            backtrack(n - 1, i, k, result);
        }
        result.stream().forEach(System.out::println);
        return result.stream().mapToInt(i -> i).toArray();
    }

    public void backtrack(int n, int num, int k, List<Integer> output) {
        if (n == 0) {
            output.add(num);
            return;
        }
        List<Integer> nextLst = new ArrayList<>();
        Integer tailDigit = num % 10;
        nextLst.add(tailDigit + k);
        if (k != 0)
            nextLst.add(tailDigit - k);
        for (Integer next : nextLst) {
            if (0 <= next && next < 10) {
                Integer newNum = num * 10 + next;
                this.backtrack(n - 1, newNum, k, output);
            }
        }
    }

}
