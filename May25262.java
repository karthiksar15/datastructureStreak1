public class May25262 {

    public static void main(String[] args) {
        May25262 may = new May25262();
        int n = 5, pick = 3;
        System.out.println("guess number-->" + may.guessNumber(n, pick));
    }

    public int guessNumber(int n, int target) {
        int l = 1;
        int r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid == target)
                return mid;
            else if (mid > n)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return -1;
    }

}
