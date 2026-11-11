import java.util.Arrays;

public class Nov11268 {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 5, 7 };
        int n = arr.length;
        int[] prefix = new int[arr.length];
        for (int i = n - 1; i >= 0; i--) {
            prefix[i] += arr[i];
        }
        Arrays.stream(prefix).forEach(System.out::println);
    }

}
