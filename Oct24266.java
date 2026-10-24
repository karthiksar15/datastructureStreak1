public class Oct24266 {

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
        Oct24266 oct = new Oct24266();
        ListNode node1 = oct.new ListNode(0);
        ListNode node2 = oct.new ListNode(1);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(2);
        node2.next = node3;
        ListNode node4 = oct.new ListNode(3);
        node3.next = node4;
        oct.reverseList(node1);
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            prev = curr;
            curr.next = prev;
            curr = temp;
        }
        return prev;
    }

}
