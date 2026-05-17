import java.util.Arrays;

public class May1726 {

    public static void main(String[] args) {
        int[] candies = { 5, 8, 6 };
        int k = 3;
        May1726 may = new May1726();
        System.out.println("shipwithin--->" + may.maximumCandies(candies, k));
    }

    public int maximumCandies(int[] weights, int days) {
        int l = 0, r = 0;
        int max = Arrays.stream(weights).max().getAsInt();
        r = max;
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(weights, days, mid)) {
                res = Math.max(res, mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    public boolean check(int[] weights, int days, int mid) {
        int tot = 0;
        for (int w : weights) {
            tot += w / mid;
        }
        if (tot >= days)
            return true;
        return false;
    }

}
