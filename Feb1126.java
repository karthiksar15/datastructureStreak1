import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Dec10 {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int find = findPlusOne(arr);
        System.out.println(find);
    }

    public static int findPlusOne(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i] + 1)) {
                ret++;
            }
        }
        return ret;
    }

}
