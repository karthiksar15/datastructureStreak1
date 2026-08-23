public class Aug20263 {

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
        Aug20263 aug = new Aug20263();
        ListNode listNode = aug.new ListNode(2);
        ListNode listNode1 = aug.new ListNode(4);
        listNode.next = listNode1;
        ListNode listNode2 = aug.new ListNode(6);
        listNode1.next = listNode2;
        ListNode listNode3 = aug.new ListNode(8);
        listNode2.next = listNode3;
        aug.reorderList(listNode);
        while (listNode != null) {
            System.out.println("reorder--");
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public void reorderList(ListNode head) {
        ListNode fastPtr = head;
        ListNode slowPtr = head;
        ListNode middle = null;
        ListNode prevMiddle = null;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            prevMiddle = slowPtr;
            slowPtr = slowPtr.next;
        }
        middle = slowPtr;
        ListNode prev = null;
        while (middle != null) {
            ListNode temp = middle.next;
            middle.next = prev;
            prev = middle;
            middle = temp;
        }
        prevMiddle.next = prev;
        ListNode first = head;

        while (prevMiddle != null) {
            ListNode temp = first.next;
            ListNode temp1 = prevMiddle.next;
            first.next = prevMiddle;
            prevMiddle.next = temp;
            first = temp;
            prevMiddle = temp1;
        }

    }

}
