public class May19262 {

    public static void main(String[] args) {
        int[] temperatures = { 30, 38, 30, 36, 35, 40, 28 };
        May19262 may = new May19262();
        System.out.println("dailytemp-->" + may.dailyTemperatures(temperatures));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                if (res[j] == 0) {
                    j = n;
                    break;
                }
                j += res[j];
            }
            if (j < n) {
                res[i] = j - i;
            }
        }
        return res;
    }

}
