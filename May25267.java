class May25267 {

    public static void main(String[] args) {
        May25267 may = new May25267();
        int[] weights = { 2, 4, 6, 1, 3, 10 };
        int days = 4;
        System.out.println("shipWithinDays--->" + may.shipWithinDays(weights, days));
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
            if (canShip(weights, days, mid)) {
                res = Math.min(res, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
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