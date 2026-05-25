public class May25263 {

    public static void main(String[] args) {
        May25263 may = new May25263();
        System.out.println("sqrt--->" + may.mySqrt(13));
    }

    public int mySqrt(int x) {
        int l = 1;
        int r = x;
        int res = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long target = (long) mid * mid;
            if (target == x)
                return mid;
            else if (target < x) {
                res = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

}
