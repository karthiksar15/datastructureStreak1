import java.util.Arrays;

public class May29263 {

    public static void main(String[] args) {
        int[] piles = { 1, 4, 3, 2 };
        int h = 9;
        May29263 may = new May29263();
        System.out.println("minEating--->" + may.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int tot = 0;
            for (int p : piles) {
                tot += Math.ceil((double) p / mid);
            }
            if (tot <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return res;
    }

}
