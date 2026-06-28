import java.util.Arrays;

public class Jun2726 {

    public static void main(String[] args) {
        Jun2726 jun = new Jun2726();
        int[] gas = { 1, 2, 3, 4 };
        int[] cost = { 2, 2, 4, 1 };
        System.out.println("complete circuit--->" + jun.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (Arrays.stream(gas).sum() < Arrays.stream(cost).sum())
            return -1;
        int total = 0;
        int res = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }

}
