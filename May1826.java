import java.util.Arrays;

public class May1826 {

    public static void main(String[] args) {
        int[] piles = { 1, 4, 3, 2 };
        int h = 9;
        May1826 may = new May1826();
        System.out.println("minEatingSpeed--->" + may.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (check(piles, h, mid)) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return res;
    }

    public boolean check(int[] piles, int h, int mid) {
        int tot = 0;
        for (int p : piles) {
            tot += Math.ceil(p / mid);
        }
        if (tot <= h)
            return true;
        return false;
    }

}
