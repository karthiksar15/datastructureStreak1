public class Dec9 {

    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        int missedNumber = findMissingNumber(nums);
        System.out.println(missedNumber);

    }

    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int tot = (n * (n + 1)) / 2;
        int sum = 0;
        for (int i : nums) {
            sum = sum + i;
        }
        return tot - sum;
    }

}
