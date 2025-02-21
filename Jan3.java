import java.util.List;

public class Jan3 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(2);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(3);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(3);
        listNode4.next = listNode5;
        ListNode temp = removeDuplicates(listNode1);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }

    public static ListNode removeDuplicates(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        while (temp != null) {
            if (prev != null && temp.val == prev.val) {
                prev.next = temp.next;
                temp = temp.next;
            } else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
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

