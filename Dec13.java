public class Dec13 {

    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text.toLowerCase()));
    }

    public static int maxNumberOfBalloons(String text) {
        int[] test = new int[256];
        String find = "balloon";
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < text.length(); i++) {
            test[text.charAt(i)]++;
        }
        int j = 0;
        while (j < find.length()) {
            int numberOfTimesCharOccured = test[find.charAt(j)];
            count = Math.min(numberOfTimesCharOccured, count);
            if (numberOfTimesCharOccured > 0)
                test[find.charAt(j)]--;
            j++;
        }
        return count;

    }

}
