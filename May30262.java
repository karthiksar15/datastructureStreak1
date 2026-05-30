import java.util.Arrays;

public class May30262 {

    public static void main(String[] args) {
        May30262 may = new May30262();
        int[] weights = { 2, 4, 6, 1, 3, 10 };
        int days = 4;
        System.out.println("shipwithin-->" + may.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        int res = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            res += w;
        }
        r = res;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canCarry(weights, days, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public boolean canCarry(int[] weights, int days, int mid) {
        int tot = 0, freq = 1;
        for (int w : weights) {
            tot += w;
            if (tot > mid) {
                freq++;
                if (freq > days) {
                    return false;
                }
                tot = w;
            }
        }
        return true;
    }

}
