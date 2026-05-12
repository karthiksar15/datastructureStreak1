public class May1126 {

    public static void main(String[] args) {
        May1126 may = new May1126();
        int x = 13;
        System.out.println("sqrt of---->" + may.mySqrt(x));
    }

    public int mySqrt(int x) {
        int low = 1;
        int high = x;
        int res = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long target = (long) mid * mid;
            if (target == x)
                return mid;
            else if (target > x) {
                res = mid - 1;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return res;
    }

}
