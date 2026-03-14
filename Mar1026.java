import java.util.Arrays;

public class Mar1026 {

    public static void main(String[] args) {
        int[] num = { 4, 2, 5, 7, 1, 3, 9 };
        insertionSort(num, 0, num.length - 1);
        System.out.println("sort--->" + Arrays.toString(num));
    }

    public static void insertionSort(int[] a, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= lo && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

}
