import java.util.Arrays;

public class May25266 {

    public static void main(String[] args) {
        int[] piles = { 1, 4, 3, 2 };
        int h = 9;
        May25266 may = new May25266();
        System.out.println("minEatingSpeed--->" + may.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        int res = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int totalTime = 0;
            for (int p : piles) {
                totalTime += Math.ceil(p / mid);
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