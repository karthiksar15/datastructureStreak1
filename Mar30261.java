import java.util.Arrays;

public class Mar30261 {

    public static void main(String[] args) {
        int[] piles = { 1, 4, 3, 2 };
        int h = 9;
        Mar30261 mar = new Mar30261();
        System.out.println("minEatingSpeed---->" + mar.minEatingSpeed(piles, h));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Arrays.stream(piles).max().getAsInt();
        int result = max;
        while (min <= max) {
            int mid = (min + (max - min) / 2);
            long totalTime = 0;
            for (int p : piles) {
                totalTime += (p + mid - 1) / mid;
            }
            if (totalTime <= h) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }

        }
        return result;
    }

}
