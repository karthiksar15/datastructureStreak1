import java.util.Arrays;

public class Mar1826 {

    public static void main(String[] args) {
        int[] arr = { 4, 2, 5, 7, 1, 3, 9 };
        sort(arr);
        System.out.println("sorted arr--->" + Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int max = 0;
        for (int i : arr) {
            max = Math.max(i, max);
        }
        int[] aux = new int[max + 1];
        for (int i : arr) {
            aux[i]++;
        }
        for (int j = 1; j <= max; j++) {
            aux[j] += aux[j - 1];
        }
        int[] out = new int[arr.length];
        for (int j = arr.length - 1; j >= 0; j--) {
            out[--aux[arr[j]]] = arr[j];
        }
        System.arraycopy(aux, 0, out, 0, arr.length);
    }
}
