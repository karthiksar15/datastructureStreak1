import java.util.Arrays;

public class Nov26262 {

    public static void main(String[] args) {
        int[] gas = { 1, 2, 3, 4 };
        int[] cost = { 2, 2, 4, 1 };
        Nov26262 nov = new Nov26262();
        System.out.println("canComplete-->" + nov.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;
        int tot = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            tot += (gas[i] - cost[i]);
            if (tot < 0) {
                tot = 0;
                res = i + 1;
            }
        }
        return res;
    }

}
