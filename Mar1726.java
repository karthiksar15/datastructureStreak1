import java.util.Arrays;

public class Mar1726 {

    public static void main(String[] args) {
        int[] arr = { -4, -2, -5, 7, 1, 3, 9 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    // LSD Radix Sort — processes digits least-significant first
    public static void sort(int[] arr) {
        int max = getMax(arr);
        int[] out = new int[arr.length];

        // Process each digit position (exp = 1, 10, 100, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countByDigit(arr, out, exp);
            System.arraycopy(out, 0, arr, 0, arr.length); // swap buffers
        }
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

    // Optimized: base-256 (4 passes for 32-bit int) — much better cache performance
    public static void sortBase256(int[] arr) {
        int n = arr.length;
        int[] out = new int[n];

        for (int shift = 0; shift < 32; shift += 8) {
            int[] count = new int[256];
            for (int x : arr)
                count[(x >> shift) & 0xFF]++;
            for (int i = 1; i < 256; i++)
                count[i] += count[i - 1];
            for (int i = n - 1; i >= 0; i--)
                out[--count[(arr[i] >> shift) & 0xFF]] = arr[i];
            int[] tmp = arr;
            arr = out;
            out = tmp; // swap without copy
        }
    }

    // MSD Radix Sort — useful for strings, in-place partitioning
    public static void sortStrings(String[] arr, int lo, int hi, int d) {
        if (lo >= hi)
            return;
        int R = 256; // extended ASCII
        int[] count = new int[R + 2];
        String[] aux = new String[hi - lo + 1];

        for (int i = lo; i <= hi; i++)
            count[charAt(arr[i], d) + 2]++;
        for (int r = 0; r < R + 1; r++)
            count[r + 1] += count[r];
        for (int i = lo; i <= hi; i++)
            aux[count[charAt(arr[i], d) + 1]++] = arr[i];
        for (int i = lo; i <= hi; i++)
            arr[i] = aux[i - lo];

        for (int r = 0; r < R; r++) // recurse on each character bucket
            sortStrings(arr, lo + count[r], lo + count[r + 1] - 1, d + 1);
    }

    private static int charAt(String s, int d) {
        return d < s.length() ? s.charAt(d) : -1; // -1 for end-of-string
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int x : arr)
            if (x > max)
                max = x;
        return max;
    }
}
