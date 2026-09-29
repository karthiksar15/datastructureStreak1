public class Sep2626 {

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
        Sep2626 sep = new Sep2626();
        ListNode listNode1 = sep.new ListNode(1);
        ListNode listNode2 = sep.new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = sep.new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = sep.new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = sep.new ListNode(5);
        listNode4.next = listNode5;
        int left = 1, right = 3;
        System.out.println("reverse between--->" + sep.reverseBetween(listNode1, left, right));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode leftPrev = dummy, cur = head;
        for (int i = 0; i < left - 1; i++) {
            leftPrev = cur;
            cur = cur.next;
        }
        ListNode prev = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode tmpNxt = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmpNxt;
        }
        leftPrev.next.next = cur;
        leftPrev.next = prev;

        return dummy.next;
    }

}
