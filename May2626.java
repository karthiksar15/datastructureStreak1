public class May2626 {

    public static void main(String[] args) {
        int[] weights = { 2, 4, 6, 1, 3, 10 };
        int days = 4;
        May2626 may = new May2626();
        System.out.println("ship--->" + may.shipWithinDays(weights, days));
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (canCarry(weights, days, mid)) {
                res = Math.min(res, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    public boolean canCarry(int[] weights, int days, int mid) {
        int check = mid, ships = 1;
        for (int w : weights) {
            if (check - w < 0) {
                ships++;
                if (ships > days)
                    return false;
                check = mid;
            }
            check -= w;
        }
        return true;
    }

}
