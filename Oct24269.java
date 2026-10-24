public class Oct24269 {

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
        Oct24269 oct = new Oct24269();
        ListNode node1 = oct.new ListNode(2);
        ListNode node2 = oct.new ListNode(4);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(6);
        node2.next = node3;
        ListNode node4 = oct.new ListNode(8);
        node3.next = node4;
        oct.reorderList(node1);
    }

    public void reorderList(ListNode head) {
        ListNode res = head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode temp = second.next;
            second.next = prev;
            prev = second;
            second = temp;
        }
        second = prev;
        while (res != null) {
            ListNode temp1 = res.next;
            ListNode temp2 = second.next;
            res.next = second;
            second.next = temp1;
            res = temp1;
            second = temp2;
        }
    }

}
