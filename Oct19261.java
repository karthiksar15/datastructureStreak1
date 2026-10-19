public class Oct19261 {

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Oct19261 oct = new Oct19261();
        ListNode listNode1 = oct.new ListNode(2);
        ListNode listNode2 = oct.new ListNode(4);
        listNode1.next = listNode2;
        ListNode listNode3 = oct.new ListNode(6);
        listNode2.next = listNode3;
        ListNode listNode4 = oct.new ListNode(8);
        listNode3.next = listNode4;
        oct.reorderList(listNode1);
        System.out.println("reorderList--->");
    }

    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }

}
