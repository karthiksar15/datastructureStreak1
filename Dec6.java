public class Dec6 {

    public static void main(String[] args) {
        int[] nums = { -3, 2, -3, 4, 2 };
        System.out.println(minStartValue(nums));
    }

    public static int minStartValue(int[] nums) {
        int min = Integer.MIN_VALUE;
        int minStart = 1;

        int[] prefix = new int[nums.length];
        while (min < 0) {
            int flag = 0;
            prefix[0] = minStart + nums[0];
            for (int i = 1; i < nums.length; i++) {
                prefix[i] = prefix[i - 1] + nums[i];
                if (prefix[i - 1] < 1) {
                    minStart += 1;
                    flag = 1;
                    break;
                }

            }
            if (flag == 0 && prefix[nums.length - 1] < 1) {
                minStart += 1;
                flag = 1;
            }
            if (flag == 0) {
                min = minStart;
            }
        }
        return min;

    }
}
