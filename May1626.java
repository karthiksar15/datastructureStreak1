public class May1626 {

    public static void main(String[] args) {
        int[] nums = { 3, 4, 4, 5, 6, 1, 2, 2 };
        int target = 1;
        May1626 may = new May1626();
        System.out.println("search--->" + may.search(nums, target));
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = 0, r = 0;
        for (int w : weights) {
            l = Math.max(l, w);
            r += w;
        }
        int res = r;
        while (l <= r) {
            int cap = (l + r) / 2;
            if (canShip(weights, days, cap)) {
                res = Math.min(res, cap);
                r = cap - 1;
            } else {
                l = cap + 1;
            }
        }
        return res;
    }

    public boolean canShip(int[] weights, int days, int cap) {
        int ships = 1, currCap = cap;
        for (int w : weights) {
            if (currCap - w < 0) {
                ships++;
                if (ships > days)
                    return false;
                currCap = cap;
            }
            currCap -= w;
        }
        return true;
    }
}
