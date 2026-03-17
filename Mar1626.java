import java.util.Arrays;

public class Mar1626 {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 5, 7, 1, 3, 9 };
        int K = 0;
        for (int i = 0; i < arr.length; i++) {
            K = Math.max(K, arr[i]);
        }
        sort(arr, K);
        System.out.println("sorted arr--->" + Arrays.toString(arr));
    }

    public static void sort(int[] arr, int maxVal) {
        int[] count = new int[maxVal + 1];
        for (int x : arr)
            count[x]++;
        for (int i = 1; i <= maxVal; i++)
            count[i] += count[i - 1];

        int[] out = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
            out[--count[arr[i]]] = arr[i];

        System.arraycopy(out, 0, arr, 0, arr.length);
    }

    public static void sortWithNegatives(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int x : arr) {
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        int[] count = new int[max - min + 1];
        for (int x : arr)
            count[x - min]++; // shift by offset
        for (int i = 1; i < count.length; i++)
            count[i] += count[i - 1];

        int[] out = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
            out[--count[arr[i] - min]] = arr[i];

        System.arraycopy(out, 0, arr, 0, arr.length);
    }

    static void countByDigit(int[] arr, int[] out, int exp) {
        int[] count = new int[10];
        for (int x : arr)
            count[(x / exp) % 10]++;
        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (int i = arr.length - 1; i >= 0; i--)
            out[--count[(arr[i] / exp) % 10]] = arr[i];
    }

}
