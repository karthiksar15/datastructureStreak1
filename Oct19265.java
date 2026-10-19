public class Oct19265 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 2 };
        Oct19265 oct = new Oct19265();
        System.out.println("find--->" + oct.findDuplicate(nums));
    }

    public int findDuplicate(int[] nums) {
        for (int n : nums) {
            int idx = Math.abs(n) - 1;
            if (nums[idx] < 0)
                return Math.abs(n);
            nums[idx] *= -1;
        }
        return -1;
    }

}
