import java.util.HashSet;
import java.util.Set;

public class Jun28261 {

    public static void main(String[] args) {
        int[][] triplets = { { 1, 2, 3 }, { 7, 1, 1 } };
        int[] target = { 7, 2, 3 };
        Jun28261 jun = new Jun28261();
        System.out.println("mergeTriplets--->" + jun.mergeTriplets(triplets, target));
    }

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        Set<Integer> good = new HashSet<>();
        for (int[] t : triplets) {
            if (t[0] > target[0] || t[1] > target[1] || t[2] > target[2])
                continue;
            for (int i = 0; i < t.length; i++) {
                if (t[i] == target[i]) {
                    good.add(i);
                }
            }
        }
        return good.size() == 3;

    }

}
