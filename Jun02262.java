import java.util.Arrays;

public class Jun02262 {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4 };
        int target = 5;
        Jun02262 jun = new Jun02262();
        System.out.println("twosum--->" + Arrays.toString(jun.twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            int sum = numbers[l] + numbers[r];
            if (sum == target)
                return new int[] { l + 1, r + 1 };
            if (sum < target)
                l++;
            else
                r--;
        }
        return new int[] {};
    }

}
