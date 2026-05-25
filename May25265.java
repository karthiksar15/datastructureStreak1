import java.util.Arrays;

public class May25265 {

    public static void main(String[] args) {
        int[] piles = { 1, 4, 3, 2 };
        int h = 9;
        May25265 may = new May25265();
        System.out.println("eating speed--->" + may.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil((double) p / mid);
            }
            if (totalTime <= h) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return res;
    }

}
