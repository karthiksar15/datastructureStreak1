public class Oct19266 {

    class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Oct19266 oct = new Oct19266();
        ListNode node1 = oct.new ListNode(1);
        ListNode node2 = oct.new ListNode(2);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(3);
        node2.next = node3;
        ListNode node4 = oct.new ListNode(4);
        node3.next = node4;
        ListNode node5 = oct.new ListNode(5);
        node4.next = node5;
        int left = 1, right = 3;
        oct.reverseBetween(node1, left, right);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy, curr = head;
        for (int i = 0; i < left - 1; i++) {
            leftPrev = curr;
            curr = curr.next;
        }
        ListNode prev = null;
    }

}
