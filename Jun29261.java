import java.util.Arrays;

public class Jun29261 {

    public static void main(String[] args) {
        int[] ratings = { 4, 3, 5 };
        Jun29261 jun = new Jun29261();
        System.out.println("candy--->" + jun.candy(ratings));
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i - 1] < ratings[i]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                arr[i] = Math.max(arr[i], arr[i + 1] + 1);
            }
        }
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

}
