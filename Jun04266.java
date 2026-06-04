import java.util.Arrays;

public class Jun04266 {

    public static void main(String[] args) {
        int[] numbers = { 1, 2, 3, 4 };
        int target = 3;
        Jun04266 jun = new Jun04266();
        System.out.println("tew===>" + Arrays.toString(jun.twoSum(numbers, target)));
    }

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target)
                return new int[] { i + 1, j + 1 };
            else if (sum > target)
                j--;
            else
                i++;
        }
        return new int[] {};
    }

}
