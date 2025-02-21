public class Jan5 {

    public static void main(String[] args) {
        // ListNode listNode1 = new ListNode(1);
        // ListNode listNode2 = new ListNode(2);
        // listNode1.next = listNode2;
        // ListNode listNode3 = new ListNode(3);
        // listNode2.next = listNode3;
        // ListNode listNode4 = new ListNode(4);
        // listNode3.next = listNode4;
        // ListNode listNode5 = new ListNode(5);
        // listNode4.next = listNode5;
        // int left = 2;
        // int right = 4;
        ListNode listNode1 = new ListNode(3);
        ListNode listNode2 = new ListNode(5);
        listNode1.next = listNode2;
        int left = 1;
        int right = 1;
        ListNode temp = reverseListNode(listNode1, left, right);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    public static ListNode reverseListNode(ListNode head, int left, int right) {
        if (head == null || head.next == null)
            return head;

        ListNode leftPart = null;
        ListNode rightPart = null;
        ListNode start = null;
        ListNode extra = new ListNode(0, head);
        ListNode temp = extra;

        while (temp != null) {
            if (left == 1) {
                start = temp.next;
                leftPart = temp;
            }
            if (right == 0) {
                rightPart = temp.next;
                temp.next = null;
                break;
            }
            right--;
            left--;
            temp = temp.next;
        }

        ListNode rev = reverse(start);
        leftPart.next = rev; // apending left part
        start.next = rightPart; // apending right part
        return extra.next;
    }

    private static ListNode reverse(ListNode node) {

        ListNode prev = null;
        ListNode next = null;
        ListNode curr = node;

        while (curr != null) {
            next = curr;
            curr = curr.next;
            next.next = prev;
            prev = next;
        }

        return prev;
    }

}

class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

