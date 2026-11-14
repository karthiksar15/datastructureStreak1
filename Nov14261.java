import java.util.HashSet;
import java.util.Set;

public class Nov14261 {

    public static void main(String[] args) {
        Nov14261 nov = new Nov14261();
        int[][] triplets = { { 1, 2, 3 }, { 7, 1, 1 } };
        int[] target = { 7, 2, 3 };
        System.out.println("merge triplets--->" + nov.mergeTriplets(triplets, target));
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> set = new HashSet<>();
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2]) {
                continue;
            }
            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    set.add(i);
                }
            }
        }
        return set.size() == 3;
    }

}
