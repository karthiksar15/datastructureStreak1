public class Oct19263 {

    class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val, ListNode next, ListNode random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public static void main(String[] args) {
        Oct19263 oct = new Oct19263();
        ListNode node1 = oct.new ListNode(3);
        ListNode node2 = oct.new ListNode(7);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(4);
        node2.next = node3;
        node3.random = node1;
        ListNode node4 = oct.new ListNode(5);
        node3.next = node4;
        node4.random = node2;
        node2.random = node4;
        oct.copyRandomList(node1);
    }

    public ListNode copyRandomList(ListNode head) {
        if (head == null)
            return null;
        ListNode l1 = head;
        while (l1 != null) {
            ListNode l2 = new ListNode(l1.val);
            l2.next = l1.random;
            l1.random = l2;
            l1 = l1.next;
        }
        ListNode newHead = head.random;
        l1 = head;
        while (l1 != null) {
            ListNode l2 = l1.random;
            l2.random = (l2.next != null) ? l2.next.random : null;
            l1 = l1.next;
        }
        l1 = head;
        while (l1 != null) {
            ListNode l2 = l1.random;
            l1.random = l2.next;
            l2.next = (l1.next != null) ? l1.next.random : null;
            l1 = l1.next;
        }
        return newHead;
    }

}
