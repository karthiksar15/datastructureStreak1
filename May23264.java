import java.util.HashMap;
import java.util.Map;

public class May23264 {

    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int n = 21;
        May23264 may = new May23264();
        System.out.println("trib-->" + may.tribonacci(n));
    }

    public int tribonacci(int n) {

        if (n <= 2) {
            return n == 0 ? 0 : 1;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }
        map.put(n, tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3));
        return map.get(n);
    }

}
