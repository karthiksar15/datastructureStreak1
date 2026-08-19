public class Aug1926 {

    class ListNode {
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
        Aug1926 aug = new Aug1926();
        ListNode listNode = aug.new ListNode(0);
        ListNode listNode1 = aug.new ListNode(1);
        listNode.next = listNode1;
        ListNode listNode2 = aug.new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = aug.new ListNode(3);
        listNode2.next = listNode3;
        ListNode reverseList = aug.reverseList(listNode);
        while (reverseList != null) {
            System.out.println("list --->");
            System.out.println(reverseList.val);
            reverseList = reverseList.next;
        }

    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

}
