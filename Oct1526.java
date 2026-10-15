public class Oct1526 {

    public class ListNode {
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
        Oct1526 oct = new Oct1526();
        ListNode node1 = oct.new ListNode(1);
        ListNode node2 = oct.new ListNode(2);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(3);
        node2.next = node3;
        ListNode node4 = oct.new ListNode(4);
        node3.next = node4;
        ListNode node5 = oct.new ListNode(5);
        node4.next = node5;
        ListNode node6 = oct.new ListNode(6);
        node5.next = node6;
        int k = 3;
        ListNode reverse = oct.reverseKGroup(node1, k);
    }

    public ListNode reverseKGroup(ListNode head, int k) {

    }
}
