public class Jan4 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;
        ListNode temp = reverseList(listNode1);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = head;
        ListNode temp = head.next;
        prev.next = null;
        while (temp != null) {
            ListNode tempNew = temp.next;
            temp.next = prev;
            prev = temp;
            temp = tempNew;
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
}

