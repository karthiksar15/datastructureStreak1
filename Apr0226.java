public class Apr0226 {

    public static void main(String[] args) {
        Apr01261 apr = new Apr01261();
        System.out.println("guessnumber--->" + apr.guessNumber(5));
    }

    public int guessNumber(int n) {

        int low = 1;
        int high = n;
        while (true) {

            int m = low + (high - low) / 2;
            int res = guess(m);
            if (res > 0)
                low = m + 1;
            else if (res < 0)
                high = m - 1;
            else
                return m;
        }
    }

    public int guess(int k) {
        int pick = 2;
        if (pick > k)
            return 1;
        else if (pick < k)
            return -1;
        else
            return 0;
    }

}
