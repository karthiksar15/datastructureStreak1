public class Oct242610 {

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
        Oct242610 oct = new Oct242610();
        ListNode node1 = oct.new ListNode(2);
        ListNode node2 = oct.new ListNode(4);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(6);
        node2.next = node3;
        ListNode node4 = oct.new ListNode(8);
        node3.next = node4;
        oct.removeNthFromEnd(node1, 2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

    }

}
