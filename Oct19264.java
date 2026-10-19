public class Oct19264 {

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
        Oct19264 oct = new Oct19264();
        ListNode node1 = oct.new ListNode(1);
        ListNode node2 = oct.new ListNode(2);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(3);
        node2.next = node3;
        ListNode node4 = oct.new ListNode(4);
        ListNode node5 = oct.new ListNode(5);
        node4.next = node5;
        ListNode node6 = oct.new ListNode(6);
        node5.next = node6;
        oct.addTwoNumbers(node1, node2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;
            res.next = new ListNode(val);
            res = res.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }
        return dummy.next;
    }

}
