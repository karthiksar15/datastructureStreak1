public class Oct24268 {

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
        Oct24268 oct = new Oct24268();
        ListNode node1 = oct.new ListNode(1);
        ListNode node2 = oct.new ListNode(2);
        node1.next = node2;
        ListNode node3 = oct.new ListNode(3);
        node2.next = node3;
        ListNode node4 = oct.new ListNode(4);
        node3.next = node4;
        node4.next = node1;

        oct.hasCycle(node1);
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
